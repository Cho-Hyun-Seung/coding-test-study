/*
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/

import java.util.*;
import java.io.*;

public class Main{
    private static Deque<Integer> deque = new LinkedList<>();
    private static void push(int num){
        deque.offer(num);
    }
    private static int pop(){
        return deque.isEmpty()? -1 :deque.poll();
    }
    private static int size(){
        return deque.size();
    }
    private static int empty(){
        return deque.isEmpty() ? 1 : 0;
    }
    private static int front(){
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }
    private static int back(){
        return deque.isEmpty() ? -1 : deque.peekLast();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0){
            String[] arr = br.readLine().split(" ");

            switch(arr[0]){
                case "push":
                    push(Integer.parseInt(arr[1]));
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
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}