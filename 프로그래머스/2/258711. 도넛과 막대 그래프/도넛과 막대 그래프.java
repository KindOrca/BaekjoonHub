import java.util.*;
class Solution {
    static List<Integer>[] adj;
    static boolean[] visited;
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int[][] inOut = new int[1000001][2];
        initArray();
        for (int[] edge : edges) {
            inOut[edge[1]][0]++;
            inOut[edge[0]][1]++;
            adj[edge[0]].add(edge[1]);
        }
        int idx = 0;
        for (int i = 0; i < 1000001; ++i) {
            if (inOut[i][0] == 0 && inOut[i][1] > 1) {
                idx = i;
                break;
            }
        }
        answer[0] = idx;
        for (int i : adj[idx]) {
            answer[findType(i)]++;
        }
        return answer;
    }
    
    static int findType(int N) {
        if (adj[N].size() > 1) return 3;
        for (int next : adj[N]) {
            if (visited[next]) return 1;
            visited[next] = true;
            return findType(next);
        }
        return 2;
    }
    
    static void initArray() {
        visited = new boolean[1000001];
        adj = new List[1000001];
        for (int i = 1; i < 1000001; ++i) {
            adj[i] = new ArrayList<>();
        }
    }
}