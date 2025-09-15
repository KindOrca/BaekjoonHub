import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), c = 0;
        String[] A = new String[N];
        for (int i = 0; i < N; ++i) A[i] = br.readLine();
        for (int i = 0; i < N; ++i) if (A[i].equals(br.readLine())) ++c;
        System.out.println(c);
    }
}