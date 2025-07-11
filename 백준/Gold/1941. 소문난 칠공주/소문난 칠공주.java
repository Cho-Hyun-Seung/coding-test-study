import java.util.*;
import java.io.*;

public class Main {
    static char[][] map = new char[5][5];
    static int result = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Set<String> set = new HashSet<>();
    static List<int[]> positions = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boolean[][] visited = new boolean[5][5];
                positions.clear();
                backT(i, j, 1, map[i][j] == 'S' ? 1 : 0, visited);
            }
        }

        System.out.println(result);
    }

    static void backT(int x, int y, int count, int sCount, boolean[][] visited) {
        visited[x][y] = true;
        positions.add(new int[]{x, y});

        if (count == 7) {
            if (sCount >= 4) {
                List<Integer> keyList = new ArrayList<>();
                for (int[] p : positions) {
                    keyList.add(p[0] * 10 + p[1]);
                }
                // 정렬해서 순서로 인해 다르게 생각하지 않도록 함
                Collections.sort(keyList);
                String key = keyList.toString();

                if (!set.contains(key)) {
                    set.add(key);
                    result++;
                }
            }

            visited[x][y] = false;
            positions.remove(positions.size() - 1);
            return;
        }

        for (int[] pos : new ArrayList<>(positions)) {
            for (int d = 0; d < 4; d++) {
                int nx = pos[0] + dx[d];
                int ny = pos[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (visited[nx][ny]) continue;

                backT(nx, ny, count + 1, sCount + (map[nx][ny] == 'S' ? 1 : 0), visited);
            }
        }

        visited[x][y] = false;
        positions.remove(positions.size() - 1);
    }
}