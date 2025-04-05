import java.io.*;
import java.util.*;

public class Main{
    static PriorityQueue<Integer> pq;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        pq = new PriorityQueue<>((a, b) -> a - b);
        
        int inputSize = Integer.parseInt(br.readLine());
        
        while(inputSize-- > 0){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                output();
            }else{
                input(num);
            }
        }
        
        System.out.println(sb);
    }
    
    private static void output(){
        if(pq.isEmpty()){
            sb.append(0).append("\n");
        }else{
            sb.append(pq.poll()).append("\n");
        }
    }
    
    private static void input(int num){
        pq.offer(num);
    }
}