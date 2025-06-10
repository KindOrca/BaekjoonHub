import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		String a = st.nextToken();
		int score = 0;
		if(a.equals("miss")) {
			score = 0;
		}else if(a.equals("bad")) {
			score = n * 200;
		}else if(a.equals("cool")) {
			score = n * 400;
		}else if(a.equals("great")) {
			score = n * 600;
		}else if(a.equals("perfect")) {
			score = n * 1000;
		}
		System.out.println(score);
	}
}