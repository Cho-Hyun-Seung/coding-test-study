import java.util.*;
import java.io.*;

public class Main{
    /*
        N : 다리를 건너는 트럭 수
        W : 다리의 길이
        L : 다리의 최대 하중
    */
    private static int N, W, L;
    private static Queue<Integer> trucks;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        trucks = new LinkedList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            trucks.offer(Integer.parseInt(st.nextToken()));
        }
        
        System.out.println(solve());
    }
    
    private static int solve() {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int nowWeight = 0;

        for (int i = 0; i < W; i++) {
            queue.add(0);
        }

        while (!trucks.isEmpty()) {
            time++;
            nowWeight -= queue.poll();

            if (!trucks.isEmpty() && nowWeight + trucks.peek() <= L) {
                int nextTruck = trucks.poll();
                queue.add(nextTruck);
                nowWeight += nextTruck;
            } else {
                queue.add(0);
            }
        }

        return time + W;
    }
}