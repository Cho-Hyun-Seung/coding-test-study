import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    private static List<List<Integer>> list;
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        
        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        System.out.println(dfs());
    }
    
    private static int dfs(){
        Stack<Integer> stack = new Stack<>();
        int response = list.get(1).size();
        // 초기 스택 채워주기
        visited[1] = true;
        for(int frd: list.get(1)){
            stack.add(frd);
            visited[frd] = true;
        }
        
        while(!stack.isEmpty()){
            int cur = stack.pop();
            
            for(int frd: list.get(cur)){
                if(!visited[frd]){
                    response += 1;
                    visited[frd] = true;
                }
            }
        }
        
        return response;
    }
}