import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        String s = "";
		if(n == 1995 || 1998 <= n && n <= 1999 || 2001 <= n && n <= 2005 || 2009 <= n && n <= 2012 || 2014 <= n && n <= 2017 || n == 2019) {
			s = "ITMO";
		}else if(n == 1996 || n == 1997 || n == 2000 || 2007 <= n && n <= 2008 || n == 2013 || n == 2018) {
			s = "SPbSU";
		}else if(n == 2006) {
			s = "PetrSU, ITMO";
		}
        System.out.println(s);
		sc.close();
	}
}