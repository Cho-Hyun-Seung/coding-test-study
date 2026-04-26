import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {

            // 1. 뒤에서 큰 값 제거
            while (!dq.isEmpty() && arr[dq.peekLast()] > arr[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // 2. 범위 벗어난 인덱스 제거
            if (dq.peekFirst() < i - L + 1) {
                dq.pollFirst();
            }

            // 3. 최소값 출력
            sb.append(arr[dq.peekFirst()]).append(" ");
        }

        System.out.println(sb);
    }
}