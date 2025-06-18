import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static Queue<Integer> que;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        que = new LinkedList<>();
        
        // 1. 값 넣어 주기
        for(int i = 1; i <= N; i++){
            que.offer(i);
        }
        
        // 2. 큐 사이즈가 1이 될 때 까지 반복
        while(que.size() >1){
            // 1. 하나 빼기
            que.poll();
            // 2. 하나 빼서 넣어주기
            que.offer(que.poll());
        }
        
        System.out.println(que.poll());
        
    }
}