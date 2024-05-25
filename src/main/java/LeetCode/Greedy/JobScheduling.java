package LeetCode.Greedy;

import java.util.*;

public class JobScheduling {

    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    int[] JobScheduling(Job arr[], int n){
        List<Job> jobs = new ArrayList<>(Arrays.asList(arr));
        jobs.sort(new Comparator<>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit - o1.profit;
            }
        });
        Map<Integer, Integer> schedule = new HashMap<>();
        int sum = 0;
        for(Job j: jobs){
            int day = findCorrectDayForSchedulingJob(schedule, j);
            if(day > 0){
                schedule.put(j.deadline, j.profit);
                sum += j.profit;
            }
        }
        int[] result = new int[2];
        result[0] = schedule.size();
        result[1] = sum;
        return result;
    }

    private int findCorrectDayForSchedulingJob(Map<Integer, Integer> schedule, Job job){
        int day = job.deadline;
        while(day >= 1 && schedule.containsKey(day)){
            day--;
        }
        return day;
    }
}
