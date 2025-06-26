import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int count = countIce();
            if (count >= 2) {
                System.out.println(year);
                return;
            }
            if (count == 0) {
                System.out.println(0);
                return;
            }
            melting();
            year++;
        }
    }

    // 빙산 덩어리 개수 세기
    static int countIce() {
        visited = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] > 0) {
                dfs(nx, ny);
            }
        }
    }

    // 빙산 녹이기
    static void melting() {
        int[][] temp = new int[N][M];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] > 0) {
                    int sea = 0;
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (isValid(nx, ny) && map[nx][ny] == 0) {
                            sea++;
                        }
                    }
                    temp[x][y] = Math.max(0, map[x][y] - sea);
                }
            }
        }

        map = temp;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
