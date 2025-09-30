import java.util.*;
import java.io.*;

/*
    - 무게가 중간인 구슬 찾기
    - 무게가 중간이 절대로 될 수 없는 구슬의 수 출력
    
    중간이 될 수 없는 조건? 자기보다 앞이나 뒤에 N/2 + 1개 있는경우
*/
public class Main {
    static int N, M;
    static Map<Integer, List<Integer>> down;
    static Map<Integer, List<Integer>> up;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        down = new HashMap<>();
        up   = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            down.put(i, new ArrayList<>());
            up.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());

            down.get(heavy).add(light);
            up.get(light).add(heavy);
        }

        int half = N / 2;
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int lightCount = bfs(down, i);
            int heavyCount = bfs(up, i);
            if (lightCount > half || heavyCount > half) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static int bfs(Map<Integer, List<Integer>> g, int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : g.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    q.offer(next);
                }
            }
        }
        return count;
    }
}