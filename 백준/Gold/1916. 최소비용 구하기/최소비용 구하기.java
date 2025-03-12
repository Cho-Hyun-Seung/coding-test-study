import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 도시 개수
        int M = Integer.parseInt(br.readLine());    // 버스 개수

        ArrayList<ArrayList<int[]>> cities = new ArrayList<>();

        for(int i = 0; i < N + 1; i++){
            cities.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            cities.get(src).add(new int[]{des, dist});
        }

        st = new StringTokenizer(br.readLine());
        int startIdx = Integer.parseInt(st.nextToken());
        int endIdx = Integer.parseInt(st.nextToken());

        int[] distArr = new int[N + 1]; // 거리 기록용 배열
        Arrays.fill(distArr, Integer.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        q.offer(new int[]{startIdx, 0});
        distArr[startIdx] = 0;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int des = current[0];
            int dist = current[1];
            // 누적 값이 더 큰 경우
            if(dist > distArr[des]) continue;

            for(int[] node: cities.get(des)){
                if(distArr[node[0]] > node[1] + dist){
                    distArr[node[0]] = node[1] + dist;
                    q.offer(new int[]{node[0], dist + node[1]});
                }
            }
        }
        System.out.println(distArr[endIdx]);
    }
}