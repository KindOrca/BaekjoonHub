import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < operations.length; ++i) {
            String[] s = operations[i].split(" ");
            if (s[0].equals("I")) {
                int l = Integer.parseInt(s[1]);
                set.add(l);
                map.put(l, map.getOrDefault(l, 0) + 1);
            } else {
                if (set.isEmpty()) continue;
                if (s[1].equals("1")) {
                    int t = set.last();
                    map.put(t, map.get(t) - 1);
                    if (map.get(t) == 0) set.pollLast();
                } else {
                    int t = set.first();
                    map.put(t, map.get(t) - 1);
                    if (map.get(t) == 0) set.pollFirst();
                }
            }
        }
        if (!set.isEmpty()) {
            answer[0] = set.last();
            answer[1] = set.first();
        }
        return answer;
    }
}