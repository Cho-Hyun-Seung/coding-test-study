import java.util.*;
import java.io.*;

public class Main {
    private static int H, W;
    private static char[][] building;
    private static boolean[][] fireVisited;
    private static boolean[][] pVisited;
    private static Queue<int[]> fireQueue;
    private static Queue<int[]> pQueue;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            init();

            boolean escaped = false;
            int result = -1;

            while (!pQueue.isEmpty()) {
                spreadFire();

                int size = pQueue.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = pQueue.poll();
                    int x = cur[0], y = cur[1], time = cur[2];

                    if (x == 0 || y == 0 || x == H - 1 || y == W - 1) {
                        result = time + 1;
                        escaped = true;
                        break;
                    }

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (0 <= nx && nx < H && 0 <= ny && ny < W &&
                            !pVisited[nx][ny] &&
                            building[nx][ny] == '.') {

                            pVisited[nx][ny] = true;
                            pQueue.add(new int[]{nx, ny, time + 1});
                        }
                    }
                }

                if (escaped) break;
            }

            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        building = new char[H][W];
        fireVisited = new boolean[H][W];
        pVisited = new boolean[H][W];
        fireQueue = new LinkedList<>();
        pQueue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            building[i] = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (building[i][j] == '*') {
                    fireQueue.add(new int[]{i, j});
                    fireVisited[i][j] = true;
                } else if (building[i][j] == '@') {
                    pQueue.add(new int[]{i, j, 0});
                    pVisited[i][j] = true;
                }
            }
        }
    }

    private static void spreadFire() {
        int size = fireQueue.size();
        for (int i = 0; i < size; i++) {
            int[] cur = fireQueue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (0 <= nx && nx < H && 0 <= ny && ny < W &&
                    !fireVisited[nx][ny] &&
                    building[nx][ny] != '#' &&
                    building[nx][ny] != '*') {

                    fireVisited[nx][ny] = true;
                    building[nx][ny] = '*';
                    fireQueue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
