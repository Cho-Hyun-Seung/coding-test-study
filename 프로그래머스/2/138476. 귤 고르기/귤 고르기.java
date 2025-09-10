import java.util.*;
import java.util.stream.*;
/*
    - k개를 골라 상자 하나에 담아 판매
    - 서로 다른 종류의 수 최소화 (hash?)
*/
class Solution {
    private static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        // 키셋을 개수 기준으로 정렬 시키기
        List<Integer> keySet = map.keySet()
            .stream()
            .sorted((a,b) -> map.get(b) - map.get(a))
            .collect(Collectors.toList());
        
        for(int key: keySet){
            if(k > 0){
                k -= map.get(key);
                answer += 1;
            }else{
                break;
            }
        }
        return answer;
    }
}