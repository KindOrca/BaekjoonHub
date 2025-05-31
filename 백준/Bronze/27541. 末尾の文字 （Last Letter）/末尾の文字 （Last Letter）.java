import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        System.out.println(s.charAt(N - 1) == 'G' ? s.substring(0, N - 1) : s + "G");
    }
}