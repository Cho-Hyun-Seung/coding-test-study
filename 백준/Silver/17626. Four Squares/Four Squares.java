import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[num + 1];
        dp[1] = 1;
        for(int i = 2; i <= num; i++){
            int minNum = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++){
                minNum = Math.min(minNum, dp[i - j*j]);   
            }
            dp[i] = minNum + 1;
        }
        System.out.println(dp[num]);
    }
}