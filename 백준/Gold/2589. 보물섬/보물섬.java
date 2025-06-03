import java.util.*;
import java.io.*;

public class Main {
    private static char[][] map;
    private static int col, row;
    private static int result;
    private static int[] dx = {-1, 1, 0, 0}; // 좌우
    private static int[] dy = {0, 0, -1, 1}; // 상하

    private static class Pair {
        int y, x, cnt;

        Pair(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    private static void bfs(int x, int y) {
        Queue<Pair> que = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        que.offer(new Pair(y, x, 0));
        visited[y][x] = true;

        while (!que.isEmpty()) {
            Pair cur = que.poll();
            result = Math.max(result, cur.cnt);

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (isValid(nx, ny) && map[ny][nx] == 'L' && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    que.offer(new Pair(ny, nx, cur.cnt + 1));
                }
            }
        }
    }

    private static boolean isEdge(int x, int y) {
        int hcount = 0, wcount = 0, count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny) && map[ny][nx] == 'L') {
                count++;
                if (i == 0 || i == 1) hcount++;  // 좌우
                else wcount++;                 // 상하
            }
        }

        return count == 1 || (count == 2 && hcount == 1 && wcount == 1);
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < col && y >= 0 && y < row;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];

        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 'L' && isEdge(j, i)) {
                    bfs(j, i);
                }
            }
        }

        System.out.println(result);
    }
}
