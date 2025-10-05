import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0 ;
        int L = friends.length;
        Map<String, Integer> nameToIdx = new HashMap<>();
        int[][] fromTo = new int[L][L];
        int[] score = new int[L];
        for (int i = 0; i < L; ++i) {
            nameToIdx.put(friends[i], i);
        }
        for (String gift : gifts) {
            String[] tmp = gift.split(" ");
            int A = nameToIdx.get(tmp[0]);
            int B = nameToIdx.get(tmp[1]);
            fromTo[A][B]++;
            score[A]++;
            score[B]--;
        }
        int cnt = 0, tmp;
        for (int i = 0; i < L; ++i) {
            tmp = 0;
            for (int j = 0; j < L; ++j) {
                if (fromTo[i][j] > fromTo[j][i]) {
                    tmp++;
                } else if (fromTo[i][j] + fromTo[j][i] == 0 || fromTo[i][j] == fromTo[j][i]) {
                    tmp += (score[i] > score[j] ? 1 : 0);
                }
                cnt = Math.max(cnt, tmp);
            }
        }
        return cnt;
    }
}