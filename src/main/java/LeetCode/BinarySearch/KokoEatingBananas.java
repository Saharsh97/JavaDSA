package LeetCode.BinarySearch;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] A, int totalH) {
        int max = Integer.MIN_VALUE;
        for(Integer x: A){
            max = Math.max(max, x);
        }
        int n = A.length;

        int lo = 1;
        int hi = Integer.MAX_VALUE;
        int mid;
        int answer = 0;
        while(lo <= hi){
            mid = lo + (hi - lo)/2;

            int hours = hoursNeeded(A, mid, max);

            if(hours > totalH){
                lo = mid+1;
            }
            if(hours < totalH){
                answer = mid;
                hi = mid-1;
            }
            if(hours == totalH){
                hi = mid-1;
                answer = mid;
            }
        }
        return answer;
    }

    public int hoursNeeded(int[] A, int k, int max){
        int n = A.length;
        int totalHours = 0;
        for(int i = 0; i < n; i++){
            if(A[i] > k){
                totalHours += A[i]%k == 0 ? A[i]/k : (A[i]/k + 1);
            } else {
                totalHours++;
            }
        }
        return totalHours;
    }
}
