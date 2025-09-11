import java.util.*;
/* 먼가 dfs 쓰면 메모리 터질거 같음... dp로 풀기?*/
/*
1: 1 1
2: 2 11 2
3: 3 111 12 21
4: 5 1111 112 121 22
5: 8 11111 1112 1121 1211 2111 212 221 122
피보나치?
*/
class Solution {
    private static int[] dp;
    private static int mod = 1234567;
    public long solution(int n) {
        long answer = 0;
        dp = new int[n + 1];
        if(n >= 1) dp[1] = 1;
        if(n >= 2) dp[2] = 2;
        
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) %1234567;
        }
        return dp[n];
    }
}