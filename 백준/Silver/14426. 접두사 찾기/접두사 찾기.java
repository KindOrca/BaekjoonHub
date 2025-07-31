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
    Trie() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); ++i) {
            int c = word.charAt(i) - 'a';
            if (node.child[c] == null) {
                node.child[c] = new Node();
            }
            node = node.child[c];
        }
        node.endOfWord = true;
    }

    boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); ++i) {
            int c = word.charAt(i) - 'a';
            if (node.child[c] == null) return false;
            node = node.child[c];
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();
        int cnt = 0;
        while (N-- > 0) trie.insert(br.readLine());
        while (M-- > 0) cnt += trie.search(br.readLine()) ? 1 : 0;
        System.out.println(cnt);
    }
}