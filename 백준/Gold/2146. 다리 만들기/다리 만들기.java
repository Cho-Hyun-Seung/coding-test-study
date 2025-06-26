import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int result = Integer.MAX_VALUE;
        
        map = new int[N][N];
        
        for(int i = 0; i < N; i++){
            String[] strArr = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        
        visited = new boolean[N][N];
        int num = 2;
        // 번호 부여하기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    numbering(i, j, num);
                    num += 1;
                }
            }
        }
        
        // 섬 모퉁이에서 돌면서 다리 놓기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2 && positiveSpace(i, j)) {
                    int dist = bfs(i, j, map[i][j]);
                    if (dist > 0) {
                        result = Math.min(result, dist);
                    }
                }
            }
        }
        System.out.println(result);
    }
    
    // 유망한 위치인가?
    public static boolean positiveSpace(int x, int y){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!isValid(nx, ny) || map[nx][ny] == 0) return true;
        }
        return false;
    }
    
    public static boolean isValid(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
    
    // 섬마다 번호 부여하기
    public static void numbering(int x, int y, int num){
        Queue<int[]> que = new LinkedList<>();
        visited[x][y] = true;
        que.offer(new int[]{x, y});
        map[x][y] = num;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1){
                    que.offer(new int[]{nx, ny});
                    map[nx][ny] = num;
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    public static int bfs(int x, int y, int num) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visitedBfs = new boolean[N][N];

        q.offer(new int[]{x, y, 0});
        visitedBfs[x][y] = true;

       while (!q.isEmpty()) {
            int[] cur = q.poll();
            int dist = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(isValid(nx, ny) && !visitedBfs[nx][ny]){
                    // 다른 곳
                    if(map[nx][ny] != 0 && map[nx][ny] != num){
                        return dist;
                    }
                    // 바다
                    if(map[nx][ny] == 0){
                        q.offer(new int[]{nx, ny, dist + 1});
                        visitedBfs[nx][ny] = true;
                    }
                }
            }
        }
        // 바다 없음
        return -1;
    }
    
}