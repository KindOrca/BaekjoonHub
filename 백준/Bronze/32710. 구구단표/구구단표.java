import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(s(Integer.parseInt(br.readLine())));
    }

    static int s(int N) {
        for (int i = 1; i < 10; ++i) {
            for (int j = 1; j < 10; ++j) {
                if (i * j == N) return 1;
            }
        }
        return 0;
    }
}