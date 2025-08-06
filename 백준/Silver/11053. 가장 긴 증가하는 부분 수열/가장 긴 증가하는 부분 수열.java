import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static int[] arr;
    private static int[] dp;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 1);
        
        longestNum();
        
        int answer = Arrays.stream(dp).max().orElse(0);
        
        System.out.println(answer);
    }
    
    private static void longestNum(){
        
        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
    }
}