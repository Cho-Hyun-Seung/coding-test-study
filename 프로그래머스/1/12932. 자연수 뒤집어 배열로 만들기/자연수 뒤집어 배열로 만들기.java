import java.util.*;

class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int size = s.length();
        int[] answer = new int[size];
        
        for(int i = 0; i < size; i++){
            answer[i] = s.charAt(size -1 - i) - '0';
        }
        
        return answer;
    }
}