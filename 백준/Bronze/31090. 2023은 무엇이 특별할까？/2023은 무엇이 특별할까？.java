import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N=Integer.parseInt(br.readLine()),n,d;
        while(N-->0) {
            n=Integer.parseInt(br.readLine());d=n%100;
            sb.append((n+1)%d==0?"Good":"Bye").append("\n");
        }
        System.out.println(sb);
    }
}