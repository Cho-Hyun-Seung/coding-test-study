import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {};
        
        int N = 0;
        // 노드 수 찾기
        for(int[] edge : edges){
            N = Math.max(N, Math.max(edge[0], edge[1]));
        }
        
        int[] indegree = new int[N + 1];
        int[] outdegree = new int[N + 1];
        
        for (int[] e : edges) {
            outdegree[e[0]]++;
            indegree[e[1]]++;
        }
        
        int root = 0;
        int donut = 0;
        int stick = 0;
        int eight = 0;
        
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0 && outdegree[i] >= 2){
                root = i;
            } else if (outdegree[i] == 0 && indegree[i] >= 1) {
                stick++;
            } else if (indegree[i] >= 2 && outdegree[i] >= 2) {
                eight++;
            }
        }
        
        int totalGraphs = outdegree[root];
        donut = totalGraphs - stick - eight;
        
        return new int[]{root, donut, stick, eight};
    }
}