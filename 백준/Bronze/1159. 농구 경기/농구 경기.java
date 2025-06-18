import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] A = new int[26];
        int n = Integer.parseInt(br.readLine());
        boolean check = false;
        for (int i = 0; i < n; ++i) {
            String s = br.readLine();
            char c = s.charAt(0);
            A[c - 97]++;
            if (A[c - 97] == 5) check = true;
        }
        if (check) {
            for (int i = 0; i < 26; ++i) {
                if (A[i] >= 5) System.out.print((char) (i + 97));
            }
        } else {
            System.out.println("PREDAJA");
        }
    }
}