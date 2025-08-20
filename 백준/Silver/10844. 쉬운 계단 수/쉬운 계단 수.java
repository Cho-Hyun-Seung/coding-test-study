import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static int[][] dp;
    private static final int MOD = 1000000000;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // [자릿 수][자릿 값]
        dp = new int[N + 1][10];
        int result = 0;
        
        for(int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }
        
        for(int i=2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                if(j == 9) {
                    dp[i][j] = dp[i-1][8] % MOD;
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][1] % MOD;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
                }
            }
        }
        
        for(int i = 0; i < 10; i++){
            result = (result + dp[N][i]) % 1000000000;
        }
        System.out.println(result);

    }
}