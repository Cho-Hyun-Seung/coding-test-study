import java.util.*;

class Solution {
    public long solution(long n) {
        String[] arr = String.valueOf(n).split("");
        long answer = 0;
        
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            answer += Integer.parseInt(arr[i]) * Math.pow(10,i);
        }
        return answer;
    }
}