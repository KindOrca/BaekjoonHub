import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Math.sqrt(Double.parseDouble(br.readLine()))*4);
    }
}