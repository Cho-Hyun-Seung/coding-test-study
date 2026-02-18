import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    private static int[][] arr;
    private static boolean[][] visited;
    
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        visited = new boolean[N][M];
        int max = 0;
        int count = 0;
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < N ; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    count += 1;
                    max = Math.max(max, getSize(j, i));
                }
            }
        }
        System.out.println(count + "\n" + max);
    }
    
    private static int getSize(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;
        int size = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            size += 1;
            
            for(int i = 0; i < 4; i++){
                int nx = cur[1] + dx[i];
                int ny = cur[0] + dy[i];
                
                if(nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx]
                  && arr[ny][nx] == 1){
                    q.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }
        
        return size;
    }
}