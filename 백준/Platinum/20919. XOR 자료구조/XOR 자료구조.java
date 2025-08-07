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
        for (int i = 25; i > -1; --i) {
            int idx = ((1 << i) & num) == (1 << i) ? 1 : 0;
            if (node.child[idx] == null) {
                node.child[idx] = new Node();
            }
            node = node.child[idx];
        }
    }

    int findMin(int num) {
        Node node = root;
        int ret = 0;
        for (int i = 25; i > -1; --i) {
            int idx = ((1 << i) & num) == (1 << i) ? 1 : 0;
            if (node.child[idx] != null) {
                node = node.child[idx];
            } else {
                ret += (1 << i);
                node = node.child[1 - idx];
            }
        }
        return ret;
    }

    int findMax(int num) {
        Node node = root;
        int ret = 0;
        for (int i = 25; i > -1; --i) {
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
        delete(root, num, 25);
    }

    private void delete(Node node, int num, int idx) {
        int i = ((1 << idx) & num) == (1 << idx) ? 1 : 0;
        Node cur = node.child[i];
        if (idx == 0) {
            node.child[i] = null;
        } else {
            delete(cur, num, idx - 1);
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
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            Trie trie = new Trie();
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; ++i) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            for (int i : set) trie.insert(i);
            while (q-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int t = Integer.parseInt(st.nextToken());
                if (t == 1) {
                    int v = Integer.parseInt(st.nextToken());
                    sb.append(trie.findMin(v));
                } else if (t == 2) {
                    int v = Integer.parseInt(st.nextToken());
                    sb.append(trie.findMax(v));
                } else if (t == 3) {
                    int v = Integer.parseInt(st.nextToken());
                    set.add(v);
                    sb.append(set.size());
                    trie.insert(v);
                } else if (t == 4) {
                    trie.delete(set.first());
                    sb.append(set.pollFirst());
                } else {
                    trie.delete(set.last());
                    sb.append(set.pollLast());
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}