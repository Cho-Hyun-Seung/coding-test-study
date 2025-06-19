import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            char[] function = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();

            Deque<Integer> deq = new ArrayDeque<>();
            if (N > 0) {
                String[] nums = input.substring(1, input.length() - 1).split(",");
                for (String num : nums) {
                    deq.offer(Integer.parseInt(num));
                }
            }

            boolean isReverse = false;
            boolean isError = false;

            for (char ch : function) {
                if (ch == 'R') {
                    isReverse = !isReverse;
                } else if (ch == 'D') {
                    if (deq.isEmpty()) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }
                    if (isReverse) {
                        deq.pollLast();
                    } else {
                        deq.pollFirst();
                    }
                }
            }

            if (!isError) {
                sb.append("[");
                while (!deq.isEmpty()) {
                    sb.append(isReverse ? deq.pollLast() : deq.pollFirst());
                    if (!deq.isEmpty()) sb.append(",");
                }
                sb.append("]\n");
            }
        }

        System.out.print(sb);
    }
}
