import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int cur = 1;
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            // 1. 현재 값이 더 작은 경우
            while (cur <= num) {
                stack.push(cur);
                sb.append("+\n");
                cur++;
            }

            // 상단 값이 입력 값과 같은 경우
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.print(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}
