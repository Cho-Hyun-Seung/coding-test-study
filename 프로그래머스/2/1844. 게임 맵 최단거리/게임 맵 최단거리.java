import java.util.*;

/* BFS*/
class Solution {
    private static int N, M;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length;
        
        visited = new boolean[N][M];
        
        answer = bfs(maps);
        
        return answer;
    }
    
    private static int bfs(int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(cur[0] == N-1 && cur[1] == M-1){
                return cur[2];
            }
            
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(isValid(nx, ny, maps) && !visited[nx][ny]){
                    queue.offer(new int[]{nx, ny, cur[2] + 1});
                    visited[nx][ny] = true;
                }
            }
            
        }
        return -1;
    }
    
    private static boolean isValid(int x, int y, int[][] maps){
        return x >=0 && x <N && y >= 0 && y < M && maps[x][y] == 1;
    }
}