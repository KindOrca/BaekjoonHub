import java.io.*;
import java.util.*;

class Node {
    Node[] child;
    Node() {
        child = new Node[2];
    }
}

class Trie {
    Node root;
    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node node = root;
        for (int i = 30; i > -1; --i) {
            int idx = ((1 << i) & num) == (1 << i) ? 1 : 0;
            if (node.child[idx] == null) {
                node.child[idx] = new Node();
            }
            node = node.child[idx];
        }
    }

    int search(int num) {
        Node node = root;
        int ret = 0;
        for (int i = 30; i > -1; --i) {
            int idx = ((1 << i) & num) == (1 << i) ? 1 : 0;
            if (node.child[1 - idx] != null) {
                ret += (1 << i);
                node = node.child[1 - idx];
            } else {
                node = node.child[idx];
            }
        }
        return ret;
    }

    void delete(int num) {
        delete(root, num, 30);
    }

    private void delete(Node node, int num, int idx) {
        int i = ((1 << idx) & num) == (1 << idx) ? 1 : 0;
        Node cur = node.child[i];
        idx--;
        if (idx == -1) {
            node.child[i] = null;
        } else {
            delete(cur, num, idx);
            if (cur.child[0] == null && cur.child[1] == null) {
                node.child[i] = null;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Trie trie = new Trie();
        trie.insert(0);
        Map<Integer, Integer> map = new HashMap<>();
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (t == 1) {
                trie.insert(x);
                map.put(x, map.getOrDefault(x, 0) + 1);
            } else if (t == 2) {
                map.put(x, map.get(x) - 1);
                if (map.get(x) == 0) trie.delete(x);
            } else {
                sb.append(trie.search(x)).append("\n");
            }
        }
        System.out.println(sb);
    }
}