import java.util.*;

class Solution {
    private static int N;
    private static int targetNum;
    private static int answer;
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        targetNum = target;
        
        answer = 0;
        
        dfs(numbers, 0, 0);
        
        return answer;
    }
    
    private static void dfs(int[] numbers, int sum, int idx){
        if(idx == N){
            if(sum == targetNum){
                answer +=1;
            }
            return;
        }
        
        dfs(numbers, sum + numbers[idx], idx + 1);
        dfs(numbers, sum - numbers[idx], idx + 1);
    }
}