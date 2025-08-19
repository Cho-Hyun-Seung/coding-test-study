import java.util.*;

class Solution {
    private static int dp[][];
    private static int N;
    
    public int solution(int[][] triangle) {
        int answer = 0;
        
        N = triangle.length;
        dp = new int[N][N];
        dp[0][0] = triangle[0][0];
    
        for(int i = 1; i < N; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0) { // 가장 왼쪽
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                    
                } else if (j == i){  // 가장 오른쪽
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {    // 중앙
                    // 좌 우 중 큰 수를 선택
                    int bigNum = Math.max(dp[i-1][j-1], dp[i-1][j]);
                    dp[i][j] = bigNum + triangle[i][j];
                }
            }
        }
        
        answer = Arrays.stream(dp[N-1])
            .max()
            .orElse(0);
        
        return answer;
    }
}