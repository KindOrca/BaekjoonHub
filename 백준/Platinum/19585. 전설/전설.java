import java.io.*;
import java.util.*;

class Node {
    Node[] child;
    boolean endOfWord;
    Node() {
        child = new Node[26];
        endOfWord = false;
    }
}

class Trie {
    Node root;
    Set<String> nickName;
    Trie() {
        root = new Node();
        nickName = new HashSet<>();
    }

    void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); ++i) {
            int idx = word.charAt(i) - 'a';
            if (node.child[idx] == null) {
                node.child[idx] = new Node();
            }
            node = node.child[idx];
        }
        node.endOfWord = true;
    }

    boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); ++i) {
            if (node.endOfWord && nickName.contains(word.substring(i))) return true;
            int idx = word.charAt(i) - 'a';
            if (node.child[idx] != null) {
                node = node.child[idx];
            } else return false;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();
        while (C-- > 0) trie.insert(br.readLine());
        while (N-- > 0) trie.nickName.add(br.readLine());
        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) sb.append(trie.search(br.readLine()) ? "Yes" : "No").append("\n");
        System.out.println(sb);
    }
}