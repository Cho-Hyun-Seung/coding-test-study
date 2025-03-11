import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        char[] charArr = s.toCharArray();
        
        for(char ch: charArr){
            if(ch == ' ') {
                sb.append(' ');
                continue;
            }
            if(ch >= 'a'){
                ch = (char)((ch-'a' + n)%26 + 'a');
            }else{
                ch = (char)((ch-'A' + n)%26 + 'A');
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}