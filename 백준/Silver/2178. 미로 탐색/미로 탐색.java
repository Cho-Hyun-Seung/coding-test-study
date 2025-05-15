import java.util.*;
import java.io.*;

class Main {
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int n, m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs());
    }
    
    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] d = queue.poll();
            int x = d[0];
            int y = d[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위 확인
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (arr[ny][nx] == 1 && !visited[ny][nx]) {
                        queue.offer(new int[]{nx, ny});
                        visited[ny][nx] = true;
                        arr[ny][nx] = arr[y][x] + 1; // 이전 칸 + 1 거리
                    }
                }
            }
        }
        
        return arr[n-1][m-1];
    }
}
