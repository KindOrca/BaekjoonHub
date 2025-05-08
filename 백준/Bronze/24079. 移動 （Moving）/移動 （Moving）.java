import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());
        int Z = Integer.parseInt(br.readLine());
        System.out.println(X + Y <= Z ? 1 : 0);
    }
}