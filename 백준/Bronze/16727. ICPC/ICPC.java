import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int p1 = sc.nextInt();
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int p2 = sc.nextInt();
        String s = "";
        if (p1 + p2 > s1 + s2) s = "Persepolis";
        else if (p1 + p2 < s1 + s2) s = "Esteghlal";
        else if (p1 + p2 == s1 + s2) {
            if (p2 > s1) s = "Persepolis";
            else if (p2 < s1) s = "Esteghlal";
            else s = "Penalty";
        }
        System.out.println(s);
    }
}