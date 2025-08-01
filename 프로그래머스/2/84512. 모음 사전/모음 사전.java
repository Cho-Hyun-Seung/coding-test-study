import java.util.*;

class Solution {
    private static char[] charArr = {'A', 'E', 'I', 'O', 'U'};
    private static int answer = 0;

    public int solution(String word) {
        dfs(word, "");
        return answer;
    }

    private boolean dfs(String targetWord, String current) {
        if (current.equals(targetWord)) {
            return true;
        }

        if (current.length() == 5) {
            return false;
        }

        for (int i = 0; i < charArr.length; i++) {
            answer++; 
            if (dfs(targetWord, current + charArr[i])) {
                return true;
            }
        }

        return false; 
    }
}
