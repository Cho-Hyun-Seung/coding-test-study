import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        
        // 그래프 내부 채워주기
        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<>());
        }
        
        // 그래프 만들어주기
        for(int[] arr: edge){
            int from = arr[0];
            int to = arr[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 0;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int num : graph.get(cur)){
                if(visited[num] == -1){
                    visited[num] = visited[cur] + 1;
                    queue.offer(num);
                }
            }
        }
        
        int max = Arrays.stream(visited).max().orElse(0);
        
        for(int i = 1; i <= n; i++){
            if(visited[i] == max){
                answer += 1;
            }
        }
        
        return answer;
    }
}