class Solution {
    public long solution(int n, int[] times) {
        long answer = binarySearch(n, times);
        return answer;
    }
    
    long binarySearch(int n, int[] times) {
        long lo = 0, hi = 1_000_000_000_000_000_001L, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (calc(n, times, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    boolean calc(int n, int[] times, long target) {
        long cnt = 0;
        for (int i = 0; i < times.length; ++i) {
            cnt += target / times[i];
        }
        return cnt >= n;
    }
}