import java.util.*;
import java.io.*;

public class Main {
    private static int M, N, H;
    private static int[][][] box;
    private static int[] dx = {-1, 1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};

    private static class Dots {
        int x, y, z, days;

        Dots(int x, int y, int z, int days) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.days = days;
        }
    }

    private static int bfs() {
        Queue<Dots> queue = new LinkedList<>();
        int result = 0;

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (box[z][y][x] == 1) {
                        queue.offer(new Dots(x, y, z, 0));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Dots dot = queue.poll();
            result = Math.max(result, dot.days);

            for (int i = 0; i < 6; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];
                int nz = dot.z + dz[i];

                if (isValid(nx, ny, nz) && box[nz][ny][nx] == 0) {
                    box[nz][ny][nx] = 1;
                    queue.offer(new Dots(nx, ny, nz, dot.days + 1));
                }
            }
        }

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (box[z][y][x] == 0) return -1;
                }
            }
        }

        return result;
    }

    private static boolean isValid(int x, int y, int z) {
        return x >= 0 && x < M && y >= 0 && y < N && z >= 0 && z < H;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    box[z][y][x] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.println(bfs());
    }
}
