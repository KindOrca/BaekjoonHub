import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);  
        int m = sc.nextInt();
        double c = (m * 0.01 + 25);
        double i;
        if (c < 100) i = 100;
        else if (2000 < (c)) i = 2000;
        else i = c;
        System.out.print(i);    
    }
}