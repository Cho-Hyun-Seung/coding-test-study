import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    private static Deque<Integer> deq;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int result = 0;
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        deq = new LinkedList<>();
        
        for(int i =1; i <= N; i++){
            deq.offerLast(i);
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int targetNum = Integer.parseInt(st.nextToken());
            // first 쪽 부터 뽑아야 하는 경우
            
            int idx = 0;
            for(int temp : deq){
                if(temp == targetNum){
                    break;
                }
                idx += 1;
            }
            
            int halfSize = deq.size() / 2;
            
            if(idx <= halfSize){
                while(deq.peekFirst() != targetNum){
                    deq.offerLast(deq.pollFirst());
                    result += 1;
                } 
            } else{
                while(deq.peekFirst() != targetNum){
                    deq.offerFirst(deq.pollLast());
                    result += 1;
                }
            }
            deq.pollFirst();
            
        }
        System.out.println(result);
        
        
        
    }
}