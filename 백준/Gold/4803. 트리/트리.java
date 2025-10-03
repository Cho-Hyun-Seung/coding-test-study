import java.util.*;
import java.io.*;

public class Main{
    static List<List<Integer>> tree;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = 1;
        
        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            // 종료 조건
            if(n == 0 && m == 0) break;
            
            tree = new ArrayList<>();
            visited = new boolean[n + 1];
            
            // 그래프 연결해주기
            for(int i = 0; i <= n; i++){
                tree.add(new ArrayList<>());
            }
            
            for(int i = 0; i< m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
            
                tree.get(a).add(b);
                tree.get(b).add(a);
            }
            
            
            int countTree = 0;
            // 트리인지 체크 하기
            for(int i = 1; i <= n; i++){
                if(!visited[i]){
                    if(isTree(i)){
                        countTree += 1;
                    }
                }
            }
            
            //결과 만들어주기
            sb.append("Case ").append(testCase).append(": ");
            if(countTree == 0){
                sb.append("No trees.");
            } else if (countTree == 1){
                sb.append("There is one tree.");
            } else{
                sb.append("A forest of ").append(countTree).append(" trees.");
            }
            sb.append("\n");
            testCase += 1;
        }
        
        System.out.println(sb.toString());
    }
    
    
    private static boolean isTree(int start){
        Deque<int[]> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(new int[]{start, 0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int parent = cur[1];
            int now = cur[0];
            
            for(int num : tree.get(now)){
                if(num == parent) continue;
                
                // 사이클이 생긴 경우
                if(visited[num]){ 
                    return false;
                }
                queue.offer(new int[]{num, now});
                visited[num] = true;
            }
        }
        
        return true;
    }
}