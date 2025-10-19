import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < N; i++){
            int order = Integer.parseInt(br.readLine());
            
            if(order == 0){
                if(pq.isEmpty()){
                    sb.append(0);
                } else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            } else {
                pq.offer(order);
            }
        }
        
        System.out.println(sb.toString());
    }
}