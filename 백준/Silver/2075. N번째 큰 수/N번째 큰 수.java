import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        StringTokenizer st;
            
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                pq.offer(num);
            }
        }
        
        for(int i = 1; i < N; i++){
            pq.poll();
        }
        
        System.out.println(pq.poll());
    }
}