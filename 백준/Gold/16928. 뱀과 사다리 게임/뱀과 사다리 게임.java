import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static boolean[] visited = new boolean[101];
    private static HashMap<Integer, Integer> moveMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            moveMap.put(from, to);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            moveMap.put(from, to);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int now = cur[0];
            int count = cur[1];

            if (now == 100) return count;

            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next > 100 || visited[next]) continue;

                if (moveMap.containsKey(next)) {
                    next = moveMap.get(next);
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, count + 1});
                }
            }
        }

        return -1;
    }
}
