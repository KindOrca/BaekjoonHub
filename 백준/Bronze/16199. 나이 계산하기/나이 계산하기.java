import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int y1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int y2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int year1;
        if (m1 < m2) year1 = y2 - y1;
        else if (m1 == m2 && d1 <= d2) year1 = y2 - y1;
        else year1 = y2 - y1 - 1;
        int year2 = y2 - y1 + 1;
        int year3 = y2 - y1;
        System.out.println(year1 + "\n" + year2 + "\n" + year3);
    }
}