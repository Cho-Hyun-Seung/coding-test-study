import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        
        if(length % 2 == 0) {
            sb.append(s.charAt(length / 2 - 1))
                .append(s.charAt(length / 2));
        } else {
            sb.append(s.charAt(length / 2));
        }
        
        return sb.toString();
    }
}