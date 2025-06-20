import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String[] s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        s = new String[N];
        int i1 = 0, i2 = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            list.add(br.readLine());
            if (list.get(list.size() - 1).equals("KBS1")) {
                i1 = i;
                list.remove(list.size() - 1);
            }
        }
        sb.append("1".repeat(i1));
        sb.append("4".repeat(i1));
        for (int i = 0; i < N - 1; ++i) {
            if (list.get(i).equals("KBS2")) i2 = i;
        }
        sb.append("1".repeat(i2 + 1));
        sb.append("4".repeat(i2));
        System.out.println(sb);
    }
}