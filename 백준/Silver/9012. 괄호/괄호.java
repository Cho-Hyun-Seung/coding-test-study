import java.util.*;
import java.io.*;

public class Main{
    private static boolean isRight(String[] brackets) {
        Stack<String> stack = new Stack<>();

        for (String bracket : brackets) {
            if (bracket.equals("(")) stack.push(bracket);
            else {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] brackets = br.readLine().split("");
            if (isRight(brackets)) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}