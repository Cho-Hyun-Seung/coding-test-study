import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        // 값 입력
        for(String name: completion){
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        // 값 찾기
        for(String name : participant) {
            if(map.get(name) == null || map.get(name) == 0){
                answer = name;
                break;
            }
            map.put(name, map.get(name) - 1);
        }
        return answer;
    }
}