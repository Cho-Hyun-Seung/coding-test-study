import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static StringBuilder sb = new StringBuilder();
    private static Deque<Integer> deque = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            
            String str = st.nextToken();
            
            switch(str) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
                default:
                    break;
            }
        }
        
        System.out.println(sb.toString());
    }
    
    private static void push(int n){
        deque.offerFirst(n);
    }
    
    private static void pop(){
        if(deque.isEmpty()){
            sb.append("-1").append("\n");
        } else {
            sb.append(deque.pollLast()).append("\n");
        }
    }
    
    private static void size(){
        sb.append(deque.size()).append("\n");
    }
    
    private static void empty(){
        if(deque.isEmpty()){
            sb.append("1").append("\n");
        } else {
            sb.append("0").append("\n");
        }
    }
    
    private static void front(){
        if(deque.isEmpty()){
            sb.append("-1").append("\n");
        } else {
            sb.append(deque.peekLast()).append("\n");
        }
    }
    
    private static void back(){
        if(deque.isEmpty()){
            sb.append("-1").append("\n");
        } else {
            sb.append(deque.peekFirst()).append("\n");
        }
    }
    
}