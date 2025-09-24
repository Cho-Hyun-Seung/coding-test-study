import java.util.*;

class Solution {
    static int[][] dp;
    static int INF = 100000000;
    
    public int solution(int[][] info, int n, int m) {
        int answer = INF;
        
        // 배낭 문제
        dp = new int[info.length + 1][m];
        for(int i = 0; i <= info.length; i++){
            Arrays.fill(dp[i] , INF);
        }
        dp[0][0] = 0;
        // i : 훔친 수, j : b 흔적 개수 [][] : a 흔적 수
        for(int i = 1; i < info.length + 1; i++){
            int a = info[i - 1][0];
            int b = info[i - 1][1];
            
            for(int j = 0; j <  m; j++){
                // a 추가하는 경우
                if(dp[i -1][j] + a < n) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
                
                // b에 들어갈 수 있는 경우
                if(j + b < m){
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]); 
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            answer = Math.min(answer, dp[info.length][i]);
        }
        
        return answer >= INF ? -1 : answer;
    }
}