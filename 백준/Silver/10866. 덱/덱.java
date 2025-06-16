import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static Deque<Integer> deque = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();; 
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            
            switch(str){
                case "push_back":
                    pushBack(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    pushFront(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    popFront();
                    break;
                case "pop_back":
                    popBack();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    isEmpty();
                    break;
                case "front":
                    peekFirst();
                    break;
                case "back":
                    peekLast();
                    break;
                default:
                    break;
            }
            
        }
        
        System.out.println(sb.toString());
    }
    
    private static void pushFront(int num){
        deque.offerFirst(num);
    }
    
    private static void pushBack(int num){
        deque.offerLast(num);
    }
    
    public static void popFront(){
        if(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        } else{
            sb.append(-1);
        }
        sb.append("\n");
    }
    
    public static void popBack(){
        if(!deque.isEmpty()){
            sb.append(deque.pollLast());
        } else{
            sb.append(-1);
        }
        sb.append("\n");
    }
    
    public static void size(){
        sb.append(deque.size()).append("\n");
    }
    
    public static void isEmpty(){
        if(deque.isEmpty()){
            sb.append(1);
        } else{
            sb.append(0);
        }
        sb.append("\n");
    }
    
    public static void peekFirst(){
        if(!deque.isEmpty()){
            sb.append(deque.peekFirst());
        } else{
            sb.append(-1);
        }
        sb.append("\n");
    }
    
    public static void peekLast(){
        if(!deque.isEmpty()){
            sb.append(deque.peekLast());
        } else{
            sb.append(-1);
        }
        sb.append("\n");
    }
}