import java.io.*;
import java.util.*;


public class Main{
    private static int N,M;
    private static int[][] map;
    private static int[] target;
    private static boolean[][] visited;
    private static int[][] resultMap;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1 ,1 ,0, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        resultMap = new int[N][M];
        visited = new boolean[N][M];
        
        // 지도 그려주기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    target = new int[]{i, j};
                }
            }
        }
        bfs();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j]){
                    sb.append(resultMap[i][j]).append(" ");
                } 
                else if (map[i][j] == 1){
                    sb.append(-1).append(" ");
                } else{
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{target[0], target[1], 0});
        visited[target[0]][target[1]] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >=0 && nx < N && ny >=0 && ny < M
                   && !visited[nx][ny] && map[nx][ny] == 1){
                    queue.offer(new int[]{nx, ny, count + 1});
                    resultMap[nx][ny] = count + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }
}