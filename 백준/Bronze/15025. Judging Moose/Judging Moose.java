import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int big = Math.max(l, r);
        if (l==0 && r==0) {
            sb.append("Not a moose");
        } else if (l == r) {
            sb.append("Even ").append(big * 2);
        } else {
            sb.append("Odd ").append(big * 2);
        }
        System.out.println(sb);
    }
}