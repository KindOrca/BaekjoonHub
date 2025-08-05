import java.io.*;
import java.util.*;

class Node {
    Node[] child;
    boolean endOfNum;
    Node() {
        child = new Node[2];
        endOfNum = false;
    }
}

class Trie {
    Node root;
    Trie() {
        root = new Node();
    }

    void insert(String num) {
        Node node = root;
        for (int i = 0; i < 31; ++i) {
            int idx = num.charAt(i) - '0';
            if (node.child[idx] == null) {
                node.child[idx] = new Node();
            }
            node = node.child[idx];
        }
        node.endOfNum = true;
    }

    int search(String num) {
        Node node = root;
        int n = 0;
        for (int i = 0; i < 31; ++i) {
            int idx = num.charAt(i) - '0';
            if (node.child[1 - idx] != null) {
                n += (1 << (30 - i));
                node = node.child[1 - idx];
            } else {
                node = node.child[idx];
            }
        }
        return n;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Trie trie = new Trie();
        int[] A = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
            trie.insert(toString(A[i]));
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            max = Math.max(max, trie.search(toString(A[i])));
        }
        System.out.println(max);
    }

    static String toString(int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 30; i > -1; --i) {
            if (((1 << i) & n) == (1 << i)) s.append("1");
            else s.append("0");
        }
        return s.toString();
    }
}