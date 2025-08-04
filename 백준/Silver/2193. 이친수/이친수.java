import java.util.*;
import java.io.*;


/*
    1: 1
    2: 10
    3: 101, 100
    4: 1010, 1000 1001
    5: 10100 10101 10001 10000, 10010
*/
public class Main{
    private static int N;
    private static long[][] dp;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        dp = new long[N][2];
        // [0인 개수, 1인 개수]
        
        dp[0] = new long[]{0, 1};
        if(N >= 2) dp[1] = new long[]{1, 0};
        
        for(int i = 2; i < dp.length; i++){
            // 이전 0의 개수 + 1의 개수
            long countZero = dp[i - 1][0] + dp[i - 1][1];
            
            // 이전 0의 개수
            long countOne = dp[i - 1][0];
            
            dp[i] = new long[]{countZero, countOne};
        }
        
        System.out.println(dp[N - 1][0] + dp[N - 1][1]);
    }
}