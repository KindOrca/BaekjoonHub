import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().substring(0, 5);
		int cnt = 0;
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			String s = br.readLine().substring(0, 5);
			if (str.equals(s)) cnt++;
		}
        System.out.println(cnt);
	}
}