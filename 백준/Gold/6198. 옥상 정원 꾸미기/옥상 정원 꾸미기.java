import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }

            result += stack.size();
            stack.push(height);
        }

        System.out.println(result);
    }
}
