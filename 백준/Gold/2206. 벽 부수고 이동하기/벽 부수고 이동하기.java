import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Point {
        int x, y, dist, isBreak;
        Point(int x, int y, int dist, int isBreak) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.isBreak = isBreak;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == M - 1 && cur.y == N - 1) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 <= nx && nx < M && 0 <= ny && ny < N) {
                    // 벽이 아닐 때
                    if (map[ny][nx] == 0 && !visited[ny][nx][cur.isBreak]) {
                        visited[ny][nx][cur.isBreak] = true;
                        q.add(new Point(nx, ny, cur.dist + 1, cur.isBreak));
                    }
                    // 벽인데 아직 안 부쉈을 때
                    if (map[ny][nx] == 1 && cur.isBreak == 0 && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        q.add(new Point(nx, ny, cur.dist + 1, 1));
                    }
                }
            }
        }
        return -1;
    }
}
