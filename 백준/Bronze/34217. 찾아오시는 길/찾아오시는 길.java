import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        A += C; B += D;
        String s;
        if (A == B) s = "Either";
        else if (A < B) s = "Hanyang Univ.";
        else s = "Yongdap";
        System.out.println(s);
    }
}