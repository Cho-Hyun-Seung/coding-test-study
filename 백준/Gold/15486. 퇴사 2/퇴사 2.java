import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static Node[] work;
    private static int[] dp;
    
    private static class Node{
        int time, price;
        
        Node(int time, int price){
            this.time = time;
            this.price = price;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        work = new Node[N + 1];
        dp = new int[N + 2];
        
        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            work[i] = new Node(t, p);
        }
        
        for (int i = 1; i <= N + 1; i++) {
            // 오늘 일 X
            dp[i] = Math.max(dp[i], dp[i - 1]);

            // 2) 오늘 일 O
            if (i <= N) {
                int finish = i + work[i].time;
                if (finish <= N + 1) {
                    dp[finish] = Math.max(dp[finish], dp[i] + work[i].price);
                }
            }
        }
        
        System.out.println(dp[N+1]);
    }
}