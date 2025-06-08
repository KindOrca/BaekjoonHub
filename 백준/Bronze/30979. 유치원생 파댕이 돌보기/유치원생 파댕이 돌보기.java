import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n = sc.nextInt();
		int total = 0;
		for(int i = 0; i < n; i++) {
			int f = sc.nextInt();
			total += f;
		}
        System.out.println(total>=t?"Padaeng_i Happy":"Padaeng_i Cry");
	}
}