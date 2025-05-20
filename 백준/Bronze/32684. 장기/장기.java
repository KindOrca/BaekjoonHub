import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cho = 0, han = 1;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        cho += Integer.parseInt(st.nextToken()) * 13;
        cho += Integer.parseInt(st.nextToken()) * 7;
        cho += Integer.parseInt(st.nextToken()) * 5;
        cho += Integer.parseInt(st.nextToken()) * 3;
        cho += Integer.parseInt(st.nextToken()) * 3;
        cho += Integer.parseInt(st.nextToken()) * 2;
        st = new StringTokenizer(br.readLine(), " ");
        han += Integer.parseInt(st.nextToken()) * 13;
        han += Integer.parseInt(st.nextToken()) * 7;
        han += Integer.parseInt(st.nextToken()) * 5;
        han += Integer.parseInt(st.nextToken()) * 3;
        han += Integer.parseInt(st.nextToken()) * 3;
        han += Integer.parseInt(st.nextToken()) * 2;
        System.out.println((cho > han) ? "cocjr0208" : "ekwoo");
    }
}