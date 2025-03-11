import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        char[] charArr = s.toCharArray();
        int idx = 0;
        for(char ch: charArr){
            // 0. 공백인 경우
            // - 인덱스 값 초기화 해주어야 함!
            if(ch == ' ') {
                sb.append(ch);
                idx = 0;
            } else {
                // 1. 인덱스가 홀수 일 경우
                if(idx % 2 == 1){
                    sb.append(Character.toString(ch).toLowerCase());
                    idx++;
                }
                // 2. 인덱스가 짝수 일 경우
                else{
                    sb.append(Character.toString(ch).toUpperCase());
                    idx++;
                }
                
            }
            
        }
        return sb.toString();
    }
}