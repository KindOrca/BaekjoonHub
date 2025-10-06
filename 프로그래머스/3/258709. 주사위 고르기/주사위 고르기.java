import java.util.*;

class Solution {
    static int N, max;
    static int[] answer;
    static int[][] dices;
    public int[] solution(int[][] dice) {
        N = dice.length;
        answer = new int[N / 2];
        dices = dice;
        solve(0, 0, new int[N / 2]);
        return answer;
    }
    
    static void solve(int K, int st, int[] arr) {
        if (K == N / 2) {
            boolean[] seq = new boolean[N];
            for (int i : arr) {
                seq[i] = true;
            }
            List<Integer> A = makeList(0, 0, seq, new ArrayList());
            Collections.sort(A);
            for (int i = 0; i < N; ++i) {
                seq[i] = !seq[i];
            }
            List<Integer> B = makeList(0, 0, seq, new ArrayList());
            if (getCount(A, B)) {
                int idx = 0;
                for (int i = 0; i < N; ++i) {
                    if (!seq[i]) answer[idx++] = i + 1;
                }
            }
            return;
        }
        for (int i = st; i < N; ++i) {
            arr[K] = i;
            solve(K + 1, i + 1, arr);
        }
    }
    
    static List<Integer> makeList(int K, int val, boolean[] seq, List<Integer> list) {
        if (K == N) {
            list.add(val);
            return list;
        }
        if (seq[K]) {
            for (int i = 0; i < 6; ++i) {
                makeList(K + 1, val + dices[K][i], seq, list);
            }
        } else {
            makeList(K + 1, val, seq, list);
        }
        return list;
    }
    
    static int upperBound(List<Integer> arr, int target) {
        int lo = 0, hi = arr.size(), mid;
        while (lo < hi) {
            mid = (lo + hi) >> 1;
            if (arr.get(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return arr.size() - hi;
    }
    
    static boolean getCount(List<Integer> A, List<Integer> B) {
        int cnt = 0;
        for (int i : B) {
            cnt += upperBound(A, i);
        }
        if (max < cnt) {
            max = cnt;
            return true;
        }
        return false;
    }
}










