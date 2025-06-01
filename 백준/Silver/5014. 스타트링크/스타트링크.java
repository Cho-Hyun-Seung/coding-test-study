import java.util.*;
import java.io.*;

public class Main{
    private static int F, S, G, U, D;
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());    // 총 층 수
        S = Integer.parseInt(st.nextToken());    // 강호의 현재 층
        G = Integer.parseInt(st.nextToken());    // 스타트링크가 있는 층
        U = Integer.parseInt(st.nextToken());    // U층 위로 가는 버튼
        D = Integer.parseInt(st.nextToken());    // D층 아래로 가는 버튼
        
        visited = new boolean[F+1];
        
        int result = bfs();
        
        if(result == -1){
            System.out.println("use the stairs");
        }else{
            System.out.println(result);
        }
        
    }
    
    private static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        visited[S] = true;
        queue.offer(new int[]{S, 0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curFloor = cur[0];
            int curCount = cur[1];
            if(curFloor == G){
                return curCount;
            }
            
            int upFloor = curFloor + U;
            int downFloor = curFloor - D;
            
            addIfValid(queue, upFloor, curCount);
            addIfValid(queue, downFloor, curCount);
        }
        
        return -1;
    }
    
    private static void addIfValid(Queue<int[]> q, int floor, int count){
        if(floor > 0 && floor <= F && !visited[floor]){
            visited[floor] = true;
            q.offer(new int[]{floor, count + 1});
        }
    }
}