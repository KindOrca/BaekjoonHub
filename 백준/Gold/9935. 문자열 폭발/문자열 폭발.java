import java.io.*;
import java.util.*;

public class Main {
    static String A, B;
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        A = br.readLine();
        B = br.readLine();
        int b = B.length();
        stack = new Stack<>();
        for (int i = 0; i < A.length(); ++i) {
            stack.push(A.charAt(i));
            if (stack.size() >= b && stack.peek() == B.charAt(b - 1)) {
                boolean check = true;
                for (int j = 1; j < b; ++j) {
                    if (stack.get(stack.size() - 1 - j) != B.charAt(b - 1 - j)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    for (int j = 0; j < b; ++j) {
                        stack.pop();
                    }
                }
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        sb.reverse();
        System.out.println(sb.isEmpty() ? "FRULA" : sb);
    }
}