import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int H = Integer.parseInt(br.readLine());
        int W = Integer.parseInt(br.readLine());
        double r = (Math.min(H, W) / 2.0) * 100;
        System.out.println((int) r);
    }
}