import java.util.*;
/*
    - n 미터 벽 존재
    - 1미터 길이 구역 n개로 나누고 좌측부터 1 ~ n
    - 롤러 길이는 m
*/
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int now = 0;
        
        for(int num : section){
            if(now >= num) continue;
            now = num + m - 1;
            answer += 1;
        }
        
        return answer;
    }
}