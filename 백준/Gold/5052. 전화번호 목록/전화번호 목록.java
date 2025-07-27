import java.io.*;
import java.util.*;

class Node {
    Map<Character, Node> child;
    boolean endOfWord;
    Node() {
        child = new HashMap<>();
    }
}

class Trie {
    Node root;
    Trie() {
        root = new Node();
    }

    boolean insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            node.child.putIfAbsent(c, new Node());
            node = node.child.get(c);
            if (node.endOfWord) return false;
        }
        if (!node.child.isEmpty()) return false;
        node.endOfWord = true;
        return true;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Trie trie = new Trie();
            boolean isConsistent = true;
            int N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                String word = br.readLine();
                if (!isConsistent) continue;
                isConsistent = trie.insert(word);
            }
            sb.append(isConsistent ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}