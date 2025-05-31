import java.io.*;
import java.util.*;

public class Main{
    private static int N,M,K,X;
    private static List<List<Integer>> cities;
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());    // 도시 개수
        M = Integer.parseInt(st.nextToken());    // 도로 개수
        K = Integer.parseInt(st.nextToken());    // 목표 거리 정보
        X = Integer.parseInt(st.nextToken());    // 출발 도시 번호
        List<Integer> answer = new ArrayList<>();
        
        cities = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            cities.add(new ArrayList<>());
        }
        
        // 도로 채우기
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            
            cities.get(src).add(dest);
        }
        
        visited = new boolean[N+1];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{X, 0});
        visited[X] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int curCity = current[0];
            int length = current[1];
            
            if(length == K){
                answer.add(curCity);
                continue;
            }
            for (int nextCity : cities.get(curCity)) {
                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(new int[]{nextCity, length + 1});
                }
            }
        }
        
        if(answer.size() > 0){
            Collections.sort(answer);
            for(int num: answer){
                System.out.println(num);
            }
            
        }else{
            System.out.println(-1);
        }
    }

}