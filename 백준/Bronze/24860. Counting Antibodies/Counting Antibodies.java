import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long vk = Long.parseLong(st.nextToken());
        long jk = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        long vl = Long.parseLong(st.nextToken());
        long jl = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        long vh = Long.parseLong(st.nextToken());
        long dh = Long.parseLong(st.nextToken());
        long jh = Long.parseLong(st.nextToken());
        System.out.print(vh * dh * jh * (vk * jk + vl * jl));
    }
}