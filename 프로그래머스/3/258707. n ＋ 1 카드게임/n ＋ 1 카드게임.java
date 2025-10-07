import java.util.*;
class Solution {
    public int solution(int coin, int[] cards) {
        int N = cards.length;
        Set<Integer> origin = new HashSet<>();
        Set<Integer> addition = new HashSet<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < N / 3; ++i) {
            origin.add(cards[i]);
        }
        for (int i : origin) {
            if (origin.contains(N + 1 - i)) {
                tmp.add(i);
            }
        }
        int cnt = tmp.size() / 2;
        System.out.println(cnt);
        for (int i : tmp) origin.remove(i);
        int K = 0;
        for (K = N / 3; K < N; K += 2) {
            addition.add(cards[K]);
            addition.add(cards[K + 1]);
            if (cnt > 0) {
                cnt--;
                continue;
            }
            if (coin == 0) break;
            int idx = 0;
            for (int i : addition) {
                if (origin.contains(N + 1 - i)) {
                    idx = i;
                    break;
                }
            }
            if (idx != 0) {
                origin.remove(N + 1 - idx);
                addition.remove(idx);
                coin--;
                continue;
            }
            if (coin == 1) break;
            int temp = 0;
            for (int i : addition) {
                if (addition.contains(N + 1 - i)) {
                    temp = i;
                    break;
                }
            }
            if (temp != 0) {
                addition.remove(temp);
                addition.remove(N + 1 - temp);
                coin -= 2;
                continue;
            }
            if (cnt == 0) break;
        }
        return (K - N / 3) / 2 + 1;
    }
}