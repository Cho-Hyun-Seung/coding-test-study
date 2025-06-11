import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static StringBuilder sb;
    private static Stack<Integer> stack;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        stack = new Stack<>();
        
        N = Integer.parseInt(br.readLine());
        
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            
            switch(num){
                case 1:
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    size();
                    break;
                case 4:
                    isEmpty();
                    break;
                case 5:
                    peek();
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb.toString());
        
    }
    
    private static void push(int num){
        stack.push(num);
    }
    
    private static void pop(){
        if(!stack.isEmpty()){
            sb.append(stack.pop()).append("\n");
        } else {
            sb.append(-1).append("\n");
        }
    }
    
    private static void size(){
        sb.append(stack.size()).append("\n");
    }
    
    private static void isEmpty(){
        if(stack.isEmpty()){
            sb.append(1);
        } else{
            sb.append(0);
        }
        sb.append("\n");
    }
    
    private static void peek(){
        if(stack.isEmpty()){
            sb.append(-1);
        }else{
            sb.append(stack.peek());
        }
        sb.append("\n");
    }
}