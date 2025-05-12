import java.util.*;

class Node implements Comparable<Node> {
    String dest;
    boolean visited;

    public Node(String dest) {
        this.dest = dest;
        this.visited = false;
    }

    @Override
    public int compareTo(Node other) {
        return this.dest.compareTo(other.dest);
    }
}

class Solution {
    Map<String, List<Node>> map;
    boolean found;
    String[] answer;

    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        found = false;
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];

            map.computeIfAbsent(from, k -> new ArrayList<>()).add(new Node(to));
        }
        for (List<Node> list : map.values()) {
            Collections.sort(list);
        }

        int totalStops = tickets.length + 1;
        answer = new String[totalStops];
        answer[0] = "ICN";
        dfs(1, totalStops, "ICN");

        return answer;
    }

    private void dfs(int depth, int totalStops, String current) {
        if (found) return;
        if (depth == totalStops) {
            found = true;
            return;
        }

        List<Node> nextList = map.getOrDefault(current, new ArrayList<>());
        for (Node node : nextList) {
            if (node.visited) continue;

            node.visited = true;
            answer[depth] = node.dest;
            dfs(depth + 1, totalStops, node.dest);
            if (found) return;
            node.visited = false;
        }
    }
}