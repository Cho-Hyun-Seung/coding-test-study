import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static Node[] arr;
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
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new Node[N + 2];
        dp = new int[N + 2];
        Arrays.fill(dp, -1);
        
        // 배열에 노드 값 넣어주기
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            arr[i] = new Node(time, price);
        }
        
        System.out.println(getMaxPrice(1));
    }
    
    private static int getMaxPrice(int day){
        if(day > N){
            return 0;
        }
        if(dp[day] != -1) return dp[day];
        
        // 오늘 상담하지 않을 경우
        int maxPrice = getMaxPrice(day + 1);
        
        // 오늘 상담 할 경우
        int finish = day + arr[day].time;
        
        // 상담 가능한 경우
        if(finish <= N + 1){
            maxPrice = Math.max(maxPrice, arr[day].price + getMaxPrice(finish));
        }
        dp[day] = maxPrice;
        
        return dp[day];
    }
}