package LeetCode.Arrays;

import LeetCode.Arrays.Structs.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<Interval> result = new ArrayList<>();
        if(n == 0){
            result.add(new Interval(newInterval[0], newInterval[1]));
            return handleAnswer(result);
        }

        int i;
        for(i = 0; i < n; i++){
            if(intervals[i][1] < newInterval[0]){
                result.add(new Interval(intervals[i][0], intervals[i][1]));
            } else break;
        }

        if(i == n){
            result.add(new Interval(newInterval[0], newInterval[1]));
        }
        else if (newInterval[1] < intervals[i][0]) {    // no overlap
            result.add(new Interval(newInterval[0], newInterval[1]));
        } else {
            i = handleOverlapScenario(i, result, intervals, newInterval);
        }

        // add remaining intervals after the merged interval.
        for(; i < n; i++) result.add(new Interval(intervals[i][0], intervals[i][1]));

        return handleAnswer(result);
    }

    private int handleOverlapScenario(int i, List<Interval> result, int[][] intervals, int[] newInterval){
        int n = intervals.length;
        int start = Math.min(intervals[i][0], newInterval[0]);
        while(i < n && intervals[i][0] <= newInterval[1]) i++;
        i--; // points to the last matching interval.
        int end = Math.max(intervals[i][1], newInterval[1]);
        result.add(new Interval(start, end));
        return i+1;
    }

    private int[][] handleAnswer(List<Interval> result){
        int[][] answer = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++){
            answer[i] = new int[]{result.get(i).start, result.get(i).end};
        }
        return answer;
    }
}
