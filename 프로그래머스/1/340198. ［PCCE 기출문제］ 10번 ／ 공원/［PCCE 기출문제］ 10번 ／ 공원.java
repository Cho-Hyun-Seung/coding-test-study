import java.util.*;

class Solution {
    private int N, M;
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        N = park.length;
        M = park[0].length;
        int[][] arr = new int[N][M];
        
        // 지도 다시 그려 주기
        for(int i = 0; i < N; i++){
            String[] p = park[i];
            for(int j = 0; j < M; j++){
                if(p[j].equals("-1")){
                    arr[i][j] = 0;   // 설치 가능
                } else {
                    arr[i][j] = -1;  // 설치 불가
                }
            }
        }
        
        int[][] dp = new int[N][M];
        int maxSize = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    } else{
                        dp[i][j] = Math.min(
                            Math.min(dp[i-1][j], dp[i][j-1]),
                            dp[i-1][j-1]
                        ) + 1;
                    }
                    
                    if(dp[i][j] > maxSize){
                        maxSize = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        Arrays.sort(mats);
        
        for(int i = mats.length - 1; i >= 0; i--){
            if(mats[i] <= maxSize){
                answer = mats[i];
                break;
            }
        }
        
        return answer;
    }
}
