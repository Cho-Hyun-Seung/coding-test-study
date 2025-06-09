import java.util.*;
import java.io.*;

public class Main{
    private static int S, D;
    private static boolean[] visited = new boolean[100001];
    
    private static class Subin{
        int now, time;
        
        Subin(int now, int time){
            this.now = now;
            this.time = time;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs());
    }
    
private static int bfs(){
    Deque<Subin> que = new ArrayDeque<>();
    que.offer(new Subin(S, 0));

    while(!que.isEmpty()){
        Subin cur = que.poll();

        // 여기서 방문 체크
        if (visited[cur.now]) continue;
        visited[cur.now] = true;

        if(cur.now == D){
            return cur.time;
        }

        int doubleNow = cur.now * 2;
        int plusNow = cur.now + 1;
        int minusNow = cur.now - 1;

        if(isValid(doubleNow)){
            que.offerFirst(new Subin(doubleNow, cur.time)); 
        }

        if(isValid(plusNow)){
            que.offer(new Subin(plusNow, cur.time + 1));
        }

        if(isValid(minusNow)){
            que.offer(new Subin(minusNow, cur.time + 1));
        }
    }

    return -1;
}
    private static boolean isValid(int num){
        return num >= 0 && num <= 100000 && !visited[num];
    }
}