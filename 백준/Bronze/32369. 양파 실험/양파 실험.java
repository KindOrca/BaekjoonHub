import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = 1, r = 1, s = 0;
		while (n-- > 0) {
			c += a;
			r += b;
			if (c < r) {
				s = c;
				c = r;
				r = s;
			} else if (c == r) {
				r--;
			}
		}
        System.out.println(c + " " + r);
	}
}