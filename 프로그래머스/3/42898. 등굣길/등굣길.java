class Solution {
    private static final int MOD = 1_000_000_007;
    private static int[][] dp;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp = new int[n + 1][m + 1];
        
        for(int[] pud: puddles){
            dp[pud[1]][pud[0]] = -1;
        }
        dp[1][1] = 1;
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                // 웅덩이 만난 경우
                if(dp[i][j] == -1) continue;
                // 위에서 오는 경우
                if(dp[i - 1][j] > 0)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                // 왼쪽에서 오는 경우
                if(dp[i][j - 1] > 0)
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
            }
        }
        return dp[n][m];
    }
    
}