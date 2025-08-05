import java.util.*;

class Solution {
    private static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        visited = new boolean[words.length];
        
        answer = dp(begin, words, target, 0);
        
        return answer;
    }
    
    private static int dp(String now, String[] words, String target, int count){
        if(now.equals(target)){
            return count;
        }
        int minCount = Integer.MAX_VALUE;
        
        for(int i = 0; i < words.length; i++){
            if(!visited[i] && hitCheck(now, words[i])){
                visited[i] = true;
                String cur = words[i];
                int result = dp(cur, words, target, count + 1);
                if(result != 0){
                    minCount = Math.min(minCount, result);
                }
                visited[i] = false;
            }
        }
        
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
    
    private static boolean hitCheck(String now, String word){
        int miss = 0;

        for(int i = 0; i < now.length(); i++){
            if(now.charAt(i) != word.charAt(i)) miss++;
            // 미스가 2개 이상이면 false 리턴
            if(miss >= 2) return false;
        }
        // System.out.println(miss);
        // 미스가 0개여도 false 리턴
        return miss == 1 ? true : false;
    }
}