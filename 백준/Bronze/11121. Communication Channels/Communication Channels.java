import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; ++i) {
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(s1.equals(s2) ? "OK" : "ERROR");
        }
    }
}