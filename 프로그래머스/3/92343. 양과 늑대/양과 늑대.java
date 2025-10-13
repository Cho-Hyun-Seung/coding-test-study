import java.util.*;

/*
    - 양 <= 늑대 일 경우 양을 모두 잡아 먹음
    - 늑대에게 잡아먹히지 않도록 하면서 최대한 많은 수의 양을 모아서 다시 루트 노드로
    - 최대 몇마리 모을 수 있는가?
*/

class Solution {
    private List<List<Integer>> list;
    private int N;
    private int maxSheep = 0;
    private int[] info;
    
    public int solution(int[] info, int[][] edges) {
        N = info.length;
        list = new ArrayList<>();
        this.info = info;
        
        for(int i = 0; i < N; i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            list.get(a).add(b);
        }
        
        int sheep = 1;
        int wolf = 0;
        
        List<Integer> childs = new ArrayList<>(list.get(0));
        
        dfs(childs, sheep, wolf);
        
        return maxSheep;
    }
    
    void dfs(List<Integer> childs, int sheep, int wolf){
        maxSheep = Math.max(sheep, maxSheep);
        
        for(int i = 0; i < childs.size(); i++){
            // 다음 방문 할 노드
            int next = childs.get(i);
            
            // 다음 방문 배열 갱신해주기
            List<Integer> newChilds = new ArrayList<>(childs);
            
            // 본인 빼고 자식 넣기
            newChilds.remove((Integer)next);
            for(int c : list.get(next)){
                newChilds.add(c);
            }
            
            int newSheep = sheep;
            int newWolf = wolf;
            
            if(info[next] == 0){
                newSheep += 1;
            } else {
                newWolf += 1;
            }
            
            if(newSheep <= newWolf) continue;
            
            dfs(newChilds, newSheep, newWolf);
        }
    }
}