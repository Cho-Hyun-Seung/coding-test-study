import java.util.*;

class Solution {
    static final int MOD = 10007;
    
    public int solution(int n, int[] tops) {
        int[] dp = new int[2 * n + 2];
        
        dp[0] = 1;
        dp[1] = 1;
        
        int topIndex = 0;
        for (int i = 2; i <= 2 * n + 1; i++) {
            if (i % 2 == 0) {
                if (tops[topIndex] == 1) {
                    dp[i] = ((2 * dp[i - 1]) + dp[i - 2]) % MOD;
                } else {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
                }
                topIndex++;
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }
        }
        return dp[2 * n + 1];
    }
}