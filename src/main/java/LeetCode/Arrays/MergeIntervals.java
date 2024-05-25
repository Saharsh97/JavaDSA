package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    class Interval{
        Integer start;
        Integer end;

        public Interval(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int[][] A) {
        int n = A.length;
        List<Interval> intervals = new ArrayList<>();
        for(int i = 0; i < n; i++){
            intervals.add(new Interval(A[i][0], A[i][1]));
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> mergedIntervals = new ArrayList<>();
        Interval current = intervals.get(0);
        for(int i = 0; i < n; i++){
            Interval thisInterval = intervals.get(i);

            if(current.start <= thisInterval.start && thisInterval.start <= current.end){
                current.end = Math.max(current.end, thisInterval.end);
            }

            if(current.end < thisInterval.start){
                mergedIntervals.add(current);
                current = thisInterval;
            }
        }
        mergedIntervals.add(current);

        int m = mergedIntervals.size();
        int[][] result = new int[m][2];
        int i = 0;
        for(Interval interval: mergedIntervals){
            result[i][0] = interval.start;
            result[i][1] = interval.end;
            i++;
        }
        return result;
    }
}
