import java.util.*;
import java.io.*;
/*
   0 1 
---------   
0: 1 0
1: 0 1
2: 1 1
3: 1 2
4: 2 3 ==> 이전 요소 2개더하는 방식!
*/

public class Main{
    private static int countZero, countOne;
    private static int[][] dp;
    private static int[] nums;
    private static int maxNum;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        maxNum = 0;
        
        nums = new int[T];
        
        // 최댓값을 찾음
        for(int i = 0; i < T; i ++){
            nums[i] = Integer.parseInt(br.readLine());
            maxNum = Math.max(nums[i], maxNum);
        }
        
        dp = new int[maxNum + 1][2];
        dp[0] = new int[]{1, 0};
        if (maxNum >= 1) {
            dp[1] = new int[]{0, 1};
        }
        
        dpFunc();
        
        for(int num : nums){
            sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    private static void dpFunc(){
        for(int i = 2; i <= maxNum; i++){
            dp[i] = new int[]{dp[i-1][0] + dp[i-2][0], dp[i-1][1] + dp[i-2][1]};
        }
    }
}