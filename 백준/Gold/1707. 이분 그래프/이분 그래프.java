import java.util.*;
import java.io.*;
/*
    - 이분 그래프 판단하기
    - 판단하는 방법? 각 집합에 속한 정점끼리 서로 인접하지 않도록 분할?
    => 인접 노드를 서로 다른 색으로 칠할 때, 두가지 색으로만 가능한 경우!
*/
public class Main{
    static List<List<Integer>> graph;
    static int[] color;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int K = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        while(K-- > 0){
            st = new StringTokenizer(br.readLine());
            
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            // 1: black, 2: red
            color = new int[V + 1];
            graph = new ArrayList<>();
            // 그래프 연결 지어주기
            for(int i = 0; i <= V; i++){
                graph.add(new ArrayList<>());
            }
            
            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            sb.append(isBipartite(1, V) ? "YES" : "NO").append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
    static boolean isBipartite(int num, int V){
        for(int i = 1; i <= V; i++){
            if(color[i] == 0){
                boolean checked = bfs(i);
                if(!checked){
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean bfs(int num){
        Deque<Integer> queue = new ArrayDeque<>();
        color[num] = 1;
        queue.offer(num);
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int curColor = color[cur];
            for(int node : graph.get(cur)){
                // 색이 칠해지지 않은 경우
                if(color[node] == 0){
                    color[node] = curColor == 1 ? 2: 1;
                    queue.offer(node);
                } else {
                    // 중복 색인 경우
                    if(color[node] == curColor){
                        return false;
                    } else{
                        continue;
                    }
                }
            }
        }
        
        // 미방문 노드가 있는 경우
        //for(int c : color){
        //    if(c == 0) return false;
        //}
        
        return true;
    }
}