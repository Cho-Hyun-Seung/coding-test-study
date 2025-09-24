import java.util.*;
import java.io.*;

public class Main{
    private static int N, K;
    private static int[][] item;
    private static int[][] dp;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        item = new int[N][2];
        
        // 아이템 배열 만들기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            item[i][0] = w;
            item[i][1] = v;
        }
        
        dp = new int[N + 1][K + 1];
        
        // i : 물건 수, j : 가치
        for (int i = 1; i <= N; i++) {
            int w = item[i - 1][0];
            int v = item[i - 1][1];
            for (int j = 0; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w] + v);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}