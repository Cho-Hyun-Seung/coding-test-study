import java.util.*;

class Solution {
    private static boolean visited[];
        
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                // 방문하지 않은 경우
                if(!visited[i]){
                    dfs(computers, i);
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
    
    private static void dfs(int[][] computers, int target){
        Stack<Integer> stack = new Stack<>();
        // 방문 처리하기
        visited[target] = true;
        // 스택에 넣기
        stack.push(target);
        
        while(!stack.isEmpty()){
            int num = stack.pop();
            for(int i = 0; i < computers[num].length; i++){
                if(computers[num][i] == 1 && !visited[i]){
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }
}