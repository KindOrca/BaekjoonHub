import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Character> list = new LinkedList<>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); ++i) {
            list.add(s.charAt(i));
        }
        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()) iter.next();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String q = br.readLine();
            switch(q.charAt(0)) {
                case 'L':
                    if(iter.hasPrevious())
                        iter.previous();
                    break;
                case 'D':
                    if(iter.hasNext())
                        iter.next();
                    break;
                case 'B':
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    iter.add(q.charAt(2));
                    break;
                default:
                    break;
            }
        }
        for (char c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}