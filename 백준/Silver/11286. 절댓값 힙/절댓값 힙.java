import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if(absA == absB) return a - b;
            return absA - absB;
        });
        
        
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(N -- > 0){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    sb.append(0);
                }else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            } else {
                pq.offer(num);
            }
        }
        
        System.out.println(sb.toString());
    }
    
}