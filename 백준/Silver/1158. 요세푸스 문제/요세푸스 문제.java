import java.util.*;
import java.io.*;

public class Main{
    private static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int count = 1;
        
        Queue<Integer> queue = new LinkedList<>();
        
        // 큐에 값 입력
        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }
        
        // 큐가 빌 때 까지 반복
        while(!queue.isEmpty()){
            // 큐에 1개만 남은 경우
            if(queue.size() == 1){
                sb.append(queue.poll());
                sb.append(">");
                break;
            }
            
            // K번 째 인 경우
            if(count == K){
                sb.append(queue.poll()).append(", ");
                count = 1;
            } else {
                // 큐에서 빼서 넣기
                queue.offer(queue.poll());
                count +=1;
            }
        }
        System.out.println(sb.toString());
    }
}