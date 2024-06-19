package Interview;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

// Our goal is to implement and demonstrate a service for connecting vaccine patients with providers.
// Patients should be able to browse available appointments, make or cancel a reservation, and review the details of their
// reservation. Providers need to manage their available appointments and review their daily appointment reservations.

// Patients may only have one reservation in total at any given time (not one per provider).

// All vaccination appointments last 30 minutes and start on the hour or half hour.
// Providers may otherwise create appointments at any time of day.

// The desired API is provided, and may be adapted to your preferred programming language.

class PatientAppointment {
    public LocalDateTime appointmentTime;
    public String providerID;
    public String patientID;
}

class ProviderAppointment {
    public LocalDateTime appointmentTime;
    public String patientID;
    public String providerID;
}

class VaccineScheduler {

    // Map<Day, List<PatientAppointment>>
    // Map<Day, List<AvailableSlots>>
    // Map<ProviderId, List<AvailableSlots>>


    // Map<PatientId, PatientAppointment>
    // Map<Day, Map<Time, List<ProverId>>>                  Available slots by providers on a day.
    // Map<ProviderId, Map<Day, Set<ProviderAppointment>>>  given a provider, it has these booked slots.

    Map<String, PatientAppointment> mapOfPatientVsPatientAppointment;
    Map<String, Map<String, Set<String>>> givenDayGivenTimeAvailableProviderIds;
    Map<String, Map<String, Set<ProviderAppointment>>> givenProviderIdGivenDaySetOfBookedProviderAppointments;

    public VaccineScheduler(){
        mapOfPatientVsPatientAppointment = new HashMap<>();
        givenDayGivenTimeAvailableProviderIds = new HashMap<>();
        givenProviderIdGivenDaySetOfBookedProviderAppointments = new HashMap<>();
    }

    /**
     * Reserve a patient appointment with this provider and appointment time
     * @param patientID A unique patient ID
     * @param providerID A unique provider ID
     * @param appointmentTime Appointment date and time
     */
    public void scheduleAppointment(String patientID, String providerID, LocalDateTime appointmentTime){
        String day = getDayFromTime(appointmentTime);
        String time = getHourMinuteFromTime(appointmentTime);

        Map<String, Set<String>> givenTimeAndAllAvailableProviders = givenDayGivenTimeAvailableProviderIds.get(day);
        if(Objects.isNull(givenTimeAndAllAvailableProviders) ||
                (Objects.isNull(givenTimeAndAllAvailableProviders.get(time)) || givenTimeAndAllAvailableProviders.get(time).isEmpty()) ||
                (!givenTimeAndAllAvailableProviders.get(time).contains(providerID))){
            System.out.println("no available providers, try again");
            return;
        }

        PatientAppointment patientAppointment = new PatientAppointment();
        patientAppointment.appointmentTime = appointmentTime;
        patientAppointment.providerID = providerID;
        patientAppointment.patientID = patientID;
        mapOfPatientVsPatientAppointment.put(patientID, patientAppointment);

        // add to booked slots map
        ProviderAppointment providerAppointment = new ProviderAppointment();
        providerAppointment.appointmentTime = appointmentTime;
        providerAppointment.patientID = patientID;
        providerAppointment.providerID = providerID;

        Map<String, Set<ProviderAppointment>> dayVsBookSlots = givenProviderIdGivenDaySetOfBookedProviderAppointments.getOrDefault(providerID, new HashMap<>());
        if(!dayVsBookSlots.containsKey(day)){
            dayVsBookSlots.put(day, new TreeSet<>(new Comparator<ProviderAppointment>() {
                @Override
                public int compare(ProviderAppointment o1, ProviderAppointment o2) {
                    return (int)toEpochMilli(o1.appointmentTime)/1000 - (int)toEpochMilli(o2.appointmentTime)/1000;
                }
            }));
        }
        dayVsBookSlots.get(day).add(providerAppointment);

        // remove from available at this time.
        givenTimeAndAllAvailableProviders.get(time).remove(providerID);
    }

    /**
     * Cancel an existing appointment for a patient. If this patient has no
     * appointment, do nothing.
     * @param patientID A unique patient ID
     */
    public void cancelAppointment(String patientID)
    {
    }

    /**
     * Get this patient's appointment information
     * @param patientID A unique patient ID
     * @return A PatientAppointment with this patient's appointment information, or
     *         null if this patient has no appointment reserved
     */
    public PatientAppointment getPatientAppointment(String patientID)
    {
        return mapOfPatientVsPatientAppointment.getOrDefault(patientID, null);
    }

    /**
     * Get open appointments on this day for patients to browse
     * @param day A calendar date
     * @return A mapping of appointment time to list of provider IDs
     *         indicating which providers have available appointments for each
     *         appointment time on this day
     */
    public Map<String, Set<String>> getAvailableAppointments(String day) {
        return givenDayGivenTimeAvailableProviderIds.getOrDefault(day, new HashMap<>());
    }

    /**
     * Make a new appointment with this provider available
     * @param providerID A unique provider ID
     * @param appointmentTime Appointment date and time
     */
    public void addAppointment(String providerID, LocalDateTime appointmentTime) {
        String day = getDayFromTime(appointmentTime);
        String time = getHourMinuteFromTime(appointmentTime);

        Map<String, Set<String>> givenTimeAndAllAvailableProviders = givenDayGivenTimeAvailableProviderIds.getOrDefault(day, new HashMap<>());
        if(!givenTimeAndAllAvailableProviders.containsKey(time)){
            givenTimeAndAllAvailableProviders.put(time, new HashSet<>());
        }
        givenDayGivenTimeAvailableProviderIds.get(day).get(time).add(providerID);
    }

    /**
     * Remove an available appointment for a provider at this time. If this
     * provider has no appointment at this time, do nothing.
     * @param providerID A unique provider ID
     * @param appointmentTime Appointment date and time
     */
    public void removeAppointment(String providerID, LocalDateTime appointmentTime)
    {
    }

    /**
     * Get this provider's patient schedule for this day
     * @param providerID A unique provider ID
     * @param day A calendar date
     * @return A list of ProviderAppointment objects (containing appointment
     *         times and patient IDs), sorted by appointment time, which
     *         represents the patient schedule for this provider on this day
     */
    public AbstractCollection<ProviderAppointment> getProviderSchedule(String providerID, String day)
    {
        Map<String, Set<ProviderAppointment>> dayVsBookSlots = givenProviderIdGivenDaySetOfBookedProviderAppointments.get(providerID);
        if(Objects.isNull(dayVsBookSlots)){
            return new ArrayList<>();
        }
        if(!dayVsBookSlots.containsKey(day)){
            return new ArrayList<>();
        }
        return new ArrayList<>(dayVsBookSlots.get(day));
    }







    private String getDayFromTime(LocalDateTime time){
        return  time.getYear() + "|" + time.getMonthValue() + "|" + time.getDayOfMonth();
    }

    private String getHourMinuteFromTime(LocalDateTime time){
        return  time.getHour() + "|" + time.getMinute();
    }

    private long toEpochMilli(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli();
    }
}