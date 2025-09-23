import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        long sum = 0; 
        int answer = 0;

        while (true) {
            if (sum >= M) {
                if (sum == M) answer++;
                sum -= arr[left++];
            } else { // sum < M
                if (right == N) break;
                sum += arr[right++];
            }
        }

        System.out.println(answer);
    }
}
