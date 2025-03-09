/*
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/

import java.util.*;
import java.io.*;

public class Main{
    private static Stack<Integer> stack = new Stack<>();

    private static void push(int num) {
        stack.push(num);
    }

    private static int pop() {
        return stack.isEmpty() ? -1 : stack.pop();
    }

    private static int size() {
        return stack.size();
    }

    private static int empty() {
        return stack.isEmpty() ? 1 : 0;
    }

    private static int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] order = br.readLine().split(" ");

            switch (order[0]) {
                case "push":
                    push(Integer.parseInt(order[1]));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}