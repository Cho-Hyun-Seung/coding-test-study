import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> keyPressMap = new HashMap<>();
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                keyPressMap.put(c, Math.min(keyPressMap.getOrDefault(c, Integer.MAX_VALUE), i + 1));
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            int total = 0;
            boolean possible = true;
            
            for (char c : targets[i].toCharArray()) {
                if (!keyPressMap.containsKey(c)) {
                    possible = false;
                    break;
                }
                total += keyPressMap.get(c);
            }
            
            answer[i] = possible ? total : -1;
        }
        
        return answer;
    }
}
