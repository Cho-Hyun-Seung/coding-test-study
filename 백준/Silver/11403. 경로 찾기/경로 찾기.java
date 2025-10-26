import java.util.*;
import java.io.*;

public class Main{
    static List<List<Integer>> graph;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        
        for(int i = 0; i < N ;i++){
            graph.add(new ArrayList<>());
        }
        
        int[][] answer = new int[N][N];
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1)
                    graph.get(i).add(j);
            }
        }
        for(int i=0;i<N;i++) dfs(i, answer, N);
        
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    public static void dfs(int start, int[][] answer, int N){
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[N];
        s.add(start);
        
        while(!s.isEmpty()){
            int cur = s.pop();
            for(int next : graph.get(cur)){
                if(!visited[next]){
                    visited[next] = true;
                    answer[start][next] = 1;
                    s.add(next);
                }
            }
        }
    }
}