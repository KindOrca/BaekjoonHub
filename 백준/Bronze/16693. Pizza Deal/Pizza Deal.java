import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble(), p = sc.nextDouble(), r = sc.nextDouble(), q = sc.nextDouble();
        double x = a / p, y = Math.PI * r * r / q;
        System.out.println(x < y ? "Whole pizza" : "Slice of pizza");
    }
}