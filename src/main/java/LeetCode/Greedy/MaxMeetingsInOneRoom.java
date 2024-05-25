package LeetCode.Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMeetingsInOneRoom {
    class Meeting{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int maxMeetings(int start[], int end[], int n) {
        List<Meeting> meetings = new ArrayList<>();
        for(int i = 0; i < n; i++){
            meetings.add(new Meeting(start[i], end[i]));
        }
        meetings.sort(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.end == o2.end ? o2.start - o1.start : o1.end - o2.end;
            }
        });

        int result = 1;
        Meeting lastMeeting = meetings.get(0);
        for(int i = 1; i < n; i++){
            if(meetings.get(i).start > lastMeeting.end){
                result++;
                lastMeeting = meetings.get(i);
            }
        }
        return result;
    }
}
