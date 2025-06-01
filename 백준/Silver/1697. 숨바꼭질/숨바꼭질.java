import java.util.*;
import java.io.*;

public class Main{
    private static int S,T;
    private static int[] map = new int[100001];
    private static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map[S] = 1;
        map[T] = 2;
        
        System.out.println(bfs());
        
    }
    
    private static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        visited[S] = true;
        q.offer(new int[]{S, 0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int now = cur[0];
            int time = cur[1];
            if(now == T){
                return time;
            }
            
            int doubleNow = now * 2;
            int minusOne = now -1;
            int plusOne = now + 1;
            
            if(validValue(doubleNow)){
                visited[doubleNow] = true;
                q.offer(new int[]{doubleNow, time+1});
            }
            
            if(validValue(minusOne)){
                visited[minusOne] = true;
                q.offer(new int[]{minusOne, time + 1});
            }
            
            if(validValue(plusOne)){
                visited[plusOne] = true;
                q.offer(new int[]{plusOne, time + 1});
            }
            
        }
        
        return -1;
    }
    
    private static boolean validValue(int num){
        return num >=0 && num <= 100000 && !visited[num];
    }
}