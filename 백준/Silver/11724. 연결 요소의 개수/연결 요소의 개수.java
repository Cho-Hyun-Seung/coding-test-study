import java.util.*;
import java.io.*;

public class Main{
    static boolean[] visited;
    static int[][] dots;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        dots = new int[N + 1][N + 1];
        visited = new boolean[N+1];
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            dots[src][dest] = dots[dest][src] = 1;
        }
        
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }
    
    private static void dfs(int x){
        Stack<Integer> stack = new Stack<>();
        stack.add(x);
        
        while(!stack.isEmpty()){
            int num = stack.pop();
            for(int i = 1; i < dots.length; i++){
                if(!visited[i] && dots[num][i] == 1){
                    stack.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}