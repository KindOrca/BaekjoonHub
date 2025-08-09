import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; ++i) {
            pq.add((long) scoville[i]);
        }
        while (pq.size() != 1) {
            if (pq.peek() >= K) break;
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
        }
        if (pq.peek() < K) answer = -1;
        return answer;
    }
}