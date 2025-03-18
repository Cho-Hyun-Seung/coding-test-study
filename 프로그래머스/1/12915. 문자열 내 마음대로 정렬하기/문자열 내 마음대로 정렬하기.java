import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Arrays.sort(strings, (a, b) -> {
            if(a.charAt(n) == b.charAt(n)) return a.compareTo(b);
            return a.charAt(n) - b.charAt(n);
        });
        for(int i = 0; i < strings.length; i++){
            answer[i] = strings[i];
        }
        return answer;
    }
}