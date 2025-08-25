import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int N = number.length() - k;
        Stack<Character> stack = new Stack<>();
        
        for(char c: number.toCharArray()){
            // 스택의 끝 값보다 입력 값이 더 클 경우
            while(!stack.isEmpty() && k > 0 && stack.peek() < c){
                stack.pop();
                k--;
            }
            
            // 스택에 c를 넣음
            stack.push(c);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            if (sb.length() == N) break;
            sb.append(c);
        }
        return sb.toString();
    }
}