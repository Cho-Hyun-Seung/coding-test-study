import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static List<List<Integer>> friends;
    public static void main(String[] args) throws IOException{
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 회원 수! 50명 이하!
        N = Integer.parseInt(br.readLine());
        friends = new ArrayList<>();
        
        for(int i = 0; i <= N; i++){
            friends.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        // 친구 관계 만들기!
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1){
                break;
            }
            friends.get(a).add(b);
            friends.get(b).add(a);
        }
        
        // 회장 후보
        List<Integer> candidate = new ArrayList<>();
        int minNum = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            int res = bfs(i);
            // 회장 갱신
            if(minNum > res){
                candidate = new ArrayList<>();
                candidate.add(i);
                minNum = res;
            } else if(minNum == res) { // 후보 추가
                candidate.add(i);
            }
        }
        
        Collections.sort(candidate);
        sb.append(minNum)
            .append(" ")
            .append(candidate.size())
            .append("\n");
        
        for(int num: candidate){
            sb.append(num).append(" ");
        }
        
        System.out.println(sb.toString());
    }
    
    private static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        int[] visited = new int[N+1];
        // -1은 미방문! 0이 자기 자신!
        Arrays.fill(visited, -1);
        int depth = 0;
        visited[start] = depth;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int friend: friends.get(cur)){
                if(visited[friend] == -1){
                    visited[friend] = visited[cur] + 1; 
                    queue.offer(friend);
                }
            }
        }
        
        return Arrays.stream(visited).max().orElse(0);
    }
}