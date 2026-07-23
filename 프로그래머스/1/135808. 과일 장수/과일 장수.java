import java.util.*;
/*
    - 최대이익
    - 상자단위로 팜!! 남으면 버림!
*/

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        for(int i = score.length - m; i >= 0; i -= m) {
            answer += score[i] * m;
        }
        return answer;
    }
}