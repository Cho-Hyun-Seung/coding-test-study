import java.util.*;

class Solution {
    private List<List<Integer>> winList;
    private List<List<Integer>> loseList;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        winList = new ArrayList<>();
        loseList = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            winList.add(new ArrayList<>());
            loseList.add(new ArrayList<>());
        }
        
        for(int[] result: results){
            /* a가 b를 이김 */
            int a = result[0];
            int b = result[1];
            winList.get(a).add(b);
            loseList.get(b).add(a);
        }
        
        // 모든 대전을 완료한 선수 찾기
        for(int i = 1; i <= n; i++){
            int winCount = dfs(winList, i);
            int loseCount = dfs(loseList, i);
            
            if(winCount + loseCount == n - 1) answer +=1;
        }
        
        return answer;
    }
    
    private int dfs(List<List<Integer>> list, int start){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[list.size()];
        stack.push(start);
        visited[start] = true;
        int count = 0;
        
        while(!stack.isEmpty()){
            int cur = stack.pop();
            List<Integer> curList = list.get(cur);
            for(int num: curList){
                if(!visited[num]){
                    stack.push(num);
                    count += 1;
                    visited[num] = true;
                }
            }
        }
        
        return count;
    }
}