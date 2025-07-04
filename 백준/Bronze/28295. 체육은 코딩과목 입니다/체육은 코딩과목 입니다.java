import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(int i = 0; i < 10; ++i) sum += Integer.parseInt(br.readLine());
        String s;
        if (sum % 4 == 0) s = "N";
        else if(sum % 4 == 1) s = "E";
        else if(sum % 4 == 2) s = "S";
        else s = "W";
        System.out.println(s);
    }
}