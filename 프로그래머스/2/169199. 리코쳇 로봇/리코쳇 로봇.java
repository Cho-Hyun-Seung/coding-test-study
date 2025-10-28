import java.util.*;

class Solution {
    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, 1, -1, 0};
    private int[][] bd;
    private int[] start;
    private int[] end;
    private int N, M;
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        bd = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            char[] c = board[i].toCharArray();
            for (int j = 0; j < M; j++) {
                if (c[j] == 'D') bd[i][j] = -1;
                if (c[j] == 'R') start = new int[]{j, i};
                if (c[j] == 'G') end = new int[]{j, i};
            }
        }
        
        return bfs();
    }
    
    private int bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[N][M];
        for (int[] d : dist) Arrays.fill(d, -1);
        
        q.offer(start);
        dist[start[1]][start[0]] = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            if (cx == end[0] && cy == end[1]) {
                return dist[cy][cx];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cx;
                int ny = cy;
                
                while (true) {
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    
                    if (!isValid(tx, ty) || bd[ty][tx] == -1) break;
                    
                    nx = tx;
                    ny = ty;
                }
                
                if (nx == cx && ny == cy) continue;
                
                if (dist[ny][nx] == -1) {
                    dist[ny][nx] = dist[cy][cx] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return -1;
    }
    
    private boolean isValid(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
