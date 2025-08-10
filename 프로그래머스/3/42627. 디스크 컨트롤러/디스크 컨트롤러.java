import java.util.*;

class Node {
    int idx, st, time;
    Node(int idx, int st, int time) {
        this.idx = idx;
        this.st = st;
        this.time = time;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int N = jobs.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
            if (n1.time != n2.time) return n1.time - n2.time;
            else if (n1.st != n2.st) return n1.st - n2.st;
            else return n1.idx - n2.idx;
        });
        Node[] A = new Node[N];
        for (int i = 0; i < N; ++i) {
            A[i] = new Node(i, jobs[i][0], jobs[i][1]);
        }
        Arrays.sort(A, (a, b) -> a.st - b.st);
        
        int[] times = new int[jobs.length];
        int time = 0, idx = 0, done = 0, total = 0;
        
        while (done < N) {
            while (idx < N && A[idx].st <= time) pq.add(A[idx++]);
            if (pq.isEmpty()) {
                time = Math.max(time, A[idx].st);
                continue;
            }
            Node cur = pq.poll();
            time += cur.time;
            total += time - cur.st;
            done++;
        }
        return total / N;
    }
}