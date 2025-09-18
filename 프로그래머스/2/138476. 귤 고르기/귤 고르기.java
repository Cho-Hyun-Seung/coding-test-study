import java.util.*;

class Solution {
    private static Map<Integer, Integer> map;
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        map = new HashMap<>();
        
        for(int tang: tangerine){
            map.put(tang, map.getOrDefault(tang, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        
        int selected = 0;
        for(int num : list){
            if(selected >= k){
               break; 
            }
            selected += map.get(num);
            answer += 1;
        }
        return answer;
    }
}