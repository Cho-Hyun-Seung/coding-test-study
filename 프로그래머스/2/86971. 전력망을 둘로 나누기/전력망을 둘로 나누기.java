import java.util.*;

class Solution {
    private static List<List<Integer>> conn;
    private static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        conn = new ArrayList<>();
        
        for(int i = 0; i <=n; i++){
            conn.add(new ArrayList<>());
        }
        
        // 연결 표시하기
        for(int[] wire: wires){
            conn.get(wire[0]).add(wire[1]);
            conn.get(wire[1]).add(wire[0]);
        }
        
        // 하나씩 끊어가며 체크해보기
        for(int[] wire: wires){
            visited = new boolean[n+1];
            int size = dfs(wire[0], wire[0], wire[1]);
            answer = Math.min(answer, Math.abs(n-2 * size));
        }
        return answer;
    }
    
    private int dfs(int start, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        int count = 0;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            count++;
            for (int next : conn.get(cur)) {
                if ((cur == left && next == right) 
                    || (cur == right && next == left)) continue;
                if (!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }
        return count;
    }
}