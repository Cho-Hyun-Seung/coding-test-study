import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        int[] arr = Arrays.stream((n + "").split(""))
            .sorted()
            .mapToInt(Integer::parseInt)
            .toArray();
        
        for(int i = 0; i < arr.length; i++){
            answer += arr[i] * Math.pow(10,i);
        }
        
        return answer;
    }
}