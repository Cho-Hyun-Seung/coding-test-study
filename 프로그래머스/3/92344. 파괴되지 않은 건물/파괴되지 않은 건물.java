import java.util.*;
/*
    - 공격은 직사각형 모양, 내구도 0 파괴
    - 아군은 회복 가능, 파괴된 건물도 복구 가능
    <skill>
    - type, r1, c1, r2, c2, degree
    - type 1 : 공격
    - type 2 : 회복
*/

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        
        int[][] preSum = new int[N + 1][M + 1];
        
        // 누적합 만들어주기
        for(int[] sk : skill){
            int type = sk[0];
            int r1 = sk[1];
            int c1 = sk[2];
            int r2 = sk[3];
            int c2 = sk[4];
            int degree = sk[5];
            
            degree = (type == 1) ? -degree : degree;
            
            preSum[r1][c1] += degree;
            preSum[r2 + 1][c2 + 1] += degree;
            preSum[r1][c2 + 1] -= degree;
            preSum[r2 + 1][c1] -= degree;
        }
        
        // 누적합 더해주기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(j == 0) continue;
                preSum[i][j] += preSum[i][j - 1];
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(i == 0) continue;
                preSum[i][j] += preSum[i - 1][j];
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] + preSum[i][j] > 0) answer += 1;
            }
        }
        
        return answer;
    }
}