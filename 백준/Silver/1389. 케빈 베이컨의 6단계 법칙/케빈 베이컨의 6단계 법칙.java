import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    private static List<List<Integer>> map;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new ArrayList<>();
        
        for(int i = 0; i <= N; i++){
            map.add(new ArrayList<>());
        }
        
        // 친구 관계 만들어 주기
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        int minP = 1;
        int minCount = Integer.MAX_VALUE;
        
        for(int i = 1; i <= N; i++){
            int result = bfs(i);
            if(result < minCount){
                minP = i;
                minCount = Math.min(minCount, result);
            }
        }
        
        System.out.println(minP);
        
    }
    
    private static int bfs(int p){
        Queue<int[]> queue = new LinkedList<>();
        int result = 0;
        int counter = 1;
        boolean[] visited = new boolean[N+1];
        visited[p] = true;
        queue.offer(new int[]{p, 0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curP = cur[0];
            int curC = cur[1];
            if(counter == N){
                break;
            }
            for(int nextP: map.get(curP)){
                if(!visited[nextP]){
                    result = result + curC +1;
                    visited[nextP] = true;
                    counter +=1;
                    queue.offer(new int[]{nextP, curC+1});
                }
            }
        }
        return result;
    }
    
}