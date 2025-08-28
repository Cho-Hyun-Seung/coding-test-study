import java.util.*;

class Solution {
    private static int[] mst;
    
    public int find(int u){
        if(mst[u] < 0) return u;
        return mst[u] = find(mst[u]);   // 압축
    }
    
    public boolean isContain(int u, int v){
        u = find(u);
        v = find(v);
        
        return u == v ? true : false;
    }
    
    public void makeTree(int u, int v){
        u = find(u);
        v = find(v);
        
        mst[v] = u;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int count = 0;
        
        // 0. 최소 신장 트리 선언
        mst = new int[n];
        Arrays.fill(mst, -1);
        
        // 1. 크루스칼 알고리즘을 위해 정렬해주기
        Arrays.sort(costs, new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        
        // 2. 최소 신장 트리 갱신하면서 count 세주기
        for(int[] cost: costs){
            int u = cost[0];
            int v = cost[1];
            int c = cost[2];
            
            // 이미 mst에 포함 된 경우 건너 뛰기
            if(isContain(u, v)) continue;
            
            // 아닌 경우 트리에 포함 시키기
            makeTree(u, v);
            answer += c;
            count += 1;
            
            // 모두 방문한 경우 break
            if(count == n){
                break;
            }
        }
        
        return answer;
    }
}