import java.util.*;

/*
    - S, D, T 영역 존재 각각 제곱
    - 스타상: 이전 점수 2배
    - 아차상: 해당 점수 마이너스
    - 스타상의 경우 첫번째 스타상의 점수만 2배
    - 스타상 중첩 가능
    - 스타상 & 아차상 중첩 가능
    - [점수|보너스|옵션] 세트
*/

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] arr = dartResult.toCharArray();
        int cur = 0;
        int prev = 0;
        for(char c: arr){
            // digit
            if(c - '0' >= 0 && c - '0' <= 9){
                if(cur == 1 && c== '0'){
                    cur = 10;
                    continue;
                }
                answer += cur;
                prev = cur;
                cur = c - '0';
            }
            
            // string
            if(c >= 'A' && c <= 'Z'){
                switch(c){
                    case 'S':
                        cur = (int) Math.pow(cur, 1);
                        break;
                    case 'D':
                        cur = (int) Math.pow(cur, 2);
                        break;
                    case 'T':
                        cur = (int) Math.pow(cur, 3);
                        break;
                    default:
                        break;
                }
            }
            
            // event
            if(c == '#' || c == '*'){
                if(c == '*'){
                    cur = cur * 2;
                    answer += prev;
                } else if(c == '#') {
                    cur = -cur;
                }
            }
        }
        
        return answer += cur;
    }
}