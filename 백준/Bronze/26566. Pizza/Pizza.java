import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int r1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int pizza1 = a1 / p1;
            int pizza2 = (int) (r1 * r1 * Math.PI / p2);
            if (pizza1 < pizza2) {
                System.out.println("Whole pizza");
            } else {
                System.out.println("Slice of pizza");
            }
        }
    }
}