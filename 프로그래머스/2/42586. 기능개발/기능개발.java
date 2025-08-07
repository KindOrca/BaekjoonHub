import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < progresses.length; ++i) {
            progresses[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        }
        int cnt = 1, max = progresses[0];
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < progresses.length; ++i) {
            if (max >= progresses[i]) {
                cnt++;
            } else {
                ans.add(cnt);
                cnt = 1;
                max = progresses[i];
            }
        }
        ans.add(cnt);
        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}