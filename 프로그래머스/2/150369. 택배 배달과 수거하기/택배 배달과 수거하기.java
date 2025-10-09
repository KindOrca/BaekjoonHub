import java.util.*;

class Node {
    int idx, val;
    Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long day = 0L;
        long needD = 0L, needP = 0L;

        for (int i = n - 1; i >= 0; --i) {
            needD += deliveries[i];
            needP += pickups[i];

            long trips = Math.max(
                (needD + cap - 1) / cap,
                (needP + cap - 1) / cap
            );

            if (trips > 0) {
                day += (long)(i + 1) * 2 * trips;
                needD -= trips * cap;
                needP -= trips * cap;
            }
        }
        return day;
    }
}