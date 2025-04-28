import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();
        if (c[0]+c[4]==c[8]+'0') System.out.println("YES");
        else System.out.println("NO");
    }
}