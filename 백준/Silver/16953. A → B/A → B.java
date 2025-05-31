import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(bfs(a, b));
    }

    private static int bfs(long start, long target) {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{start, 1});

        while (!queue.isEmpty()) {
            long[] curr = queue.poll();
            long value = curr[0];
            int count = (int) curr[1];

            if (value == target) return count;

            long next1 = value * 2;
            long next2 = value * 10 + 1;

            if (next1 <= target) {
                queue.offer(new long[]{next1, count + 1});
            }
            if (next2 <= target) {
                queue.offer(new long[]{next2, count + 1});
            }
        }

        return -1;
    }
}
