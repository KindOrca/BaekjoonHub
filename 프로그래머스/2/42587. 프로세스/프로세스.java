import java.util.*;

class Node {
    int p, v;
    Node(int p, int v) {
        this.p = p;
        this.v = v;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int idx = 0, pivot = 0;
        Queue<Node> que = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < priorities.length; ++i) {
            pivot = Math.max(pivot, priorities[i]);
            que.add(new Node(i, priorities[i]));
            map.put(priorities[i], map.getOrDefault(priorities[i], 0) + 1);
        }
        a: while (!que.isEmpty()) {
            int sz = que.size();
            for (int i = 0; i < sz; ++i) {
                if (que.peek().v == pivot) {
                    System.out.println(que.peek().v);
                    idx++;
                    if (que.poll().p == location) {
                        answer = idx;
                        break a;
                    }
                    map.put(pivot, map.get(pivot) - 1);
                    if (map.get(pivot) == 0) {
                        while (map.getOrDefault(pivot, 0) == 0) pivot--;
                    }
                } else que.add(que.poll());
            }
        }
        return answer;
    }
}