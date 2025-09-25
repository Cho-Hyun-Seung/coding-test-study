import java.util.*;
/*
    - m번 시도 가능
    - 시스템은 그 중 몇 개가 비밀 코드에 포함되어 있는지 알려줌
    - m번 시도 후, 비밀 코드로 가능한 정수 조합 개수
*/


class Solution {
    static int[][] q;
    static int[] ans;
    static int n;
    static int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        pickPassword(1, new boolean[n + 1], 0);
        
        return answer;
    }
    
    public void pickPassword(int idx, boolean[] code, int size){
        if(size == 5){
            // 조건 일치 여부 확인하기
            if(validPassword(code)) answer += 1;
            return;
        }
        
        for(int i = idx; i <= n; i++){
            code[i] = true;
            pickPassword(i + 1, code, size + 1);
            code[i] = false;
        }
    }
    
    public boolean validPassword(boolean[] code){
        for(int i = 0; i < q.length; i++){
            int correct = 0;
            for(int j = 0; j < 5; j++){
                // 해당 코드가 true인 경우
                int num = q[i][j];
                if(code[num]) correct += 1;
            }
            
            if(correct != ans[i]) return false;
        }
        return true;
    }
}