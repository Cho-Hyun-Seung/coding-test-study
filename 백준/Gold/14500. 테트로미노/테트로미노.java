import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int maxCell = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxCell) maxCell = map[i][j];
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                visited[y][x] = true;
                dfs(y, x, 1, map[y][x]);
                visited[y][x] = false;

                checkT(y, x);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int y, int x, int depth, int sum) {
        if (sum + (4 - depth) * maxCell <= answer) return;

        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            if (visited[ny][nx]) continue;

            visited[ny][nx] = true;
            dfs(ny, nx, depth + 1, sum + map[ny][nx]);
            visited[ny][nx] = false;
        }
    }

    static void checkT(int y, int x) {
        int center = map[y][x];

        int[] neigh = new int[4];
        int cnt = 0;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            neigh[cnt++] = map[ny][nx];
        }

        if (cnt < 3) return;

        Arrays.sort(neigh, 0, cnt);
        int sum = center;
        sum += neigh[cnt - 1] + neigh[cnt - 2] + neigh[cnt - 3];
        answer = Math.max(answer, sum);
    }
}
