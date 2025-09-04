import java.util.*;
/*
    입국 심사 대기 인원 수 n
    한명 심사하는데 걸리는 시간 times
    모든 사람 심사 시에 걸리는 시간은?
*/
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = times[0];
        // 가장 짧은 사람 혼자 다 할 경우
        long right = times[0] * (long)n;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long people = 0;
            for(int time: times){
                people += mid/time;
                if(people >= n) break;
            }
            // 시간 안에 모두 심사할 수 없는 경우?
            if(people < n){
                left = mid + 1;
            } else{
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}