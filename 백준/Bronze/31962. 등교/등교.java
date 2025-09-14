import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int mStime = -1;
		int sum = 0;
		int sTime, eTime;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			sTime = Integer.parseInt(st.nextToken());
			eTime = Integer.parseInt(st.nextToken());
			sum = sTime + eTime;
			if (sum <= x && mStime < sTime) mStime = sTime;
		}
		System.out.println(mStime);
	}
}