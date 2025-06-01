import java.util.*;
import java.io.*;

public class Main{
    private static int I;
    private static int[] now;
    private static int[] togo;
    private static int[][] board;
    private static boolean[][] visited;
    private static int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
    private static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        
        while(testCase-- > 0){
            I = Integer.parseInt(br.readLine());
            now = new int[2];
            togo = new int[2];
            board = new int[I][I];
            visited = new boolean[I][I];
            st = new StringTokenizer(br.readLine());
            
            now[0] = Integer.parseInt(st.nextToken());
            now[1] = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            togo[0] = Integer.parseInt(st.nextToken());
            togo[1] = Integer.parseInt(st.nextToken());
            
            System.out.println(bfs(now, togo));
        }
    }
    
    private static int bfs(int[] now, int[] togo){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{now[0], now[1], 0});    // x, y, count
        visited[now[0]][now[1]] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            if(x == togo[0] && y == togo[1]){
                return count;
            }
            for(int i = 0; i < 8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >=0 && nx < I && ny >=0 && ny < I && !visited[nx][ny]){
                    queue.offer(new int[]{nx, ny, count + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}