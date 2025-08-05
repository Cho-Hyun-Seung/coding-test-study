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
        for(int i = 0; i< arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(findMaxValue());
    }
    
    private static long findMaxValue(){
        dp[0] = arr[0];
        long maxValue = dp[0];
        for(int i = 1; i < arr.length; i++){
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }
}