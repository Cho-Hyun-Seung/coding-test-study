import java.util.*;
import java.io.*;

public class Main{
    static int[][] relation;
    static boolean[] visited;
    static int targetSrc;
    static int targetDest;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        relation = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        st = new StringTokenizer(br.readLine());
        targetSrc = Integer.parseInt(st.nextToken());
        targetDest = Integer.parseInt(st.nextToken());
        
        int M = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            
            relation[src][dest] = relation[dest][src] = 1;
        }
        
        int answer = dfs();
        
        System.out.println(answer);
    }
    
    private static int dfs(){
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{targetSrc, 0});
        visited[targetSrc] = true;
        
        while(!stack.isEmpty()){
            int[] arr = stack.pop();
            int src = arr[0];
            int depth = arr[1];
            if(src == targetDest){
                return depth;
            }
            for(int i = 1; i < relation.length; i++){
                if(!visited[i] && relation[src][i] == 1){
                    visited[i] = true;
                    stack.add(new int[]{i, depth+1});
                }
            }
        }
        return -1;
    }
}