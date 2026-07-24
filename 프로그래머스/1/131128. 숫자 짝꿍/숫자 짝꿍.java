import java.util.*;

/*
    - 두 숫자 사이에 공통으로 나타나는 정수 중 가장 큰 정수 출력
*/
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(char c : X.toCharArray()){
            int num = c - '0';
            map.put(num , map.getOrDefault(num, 0) + 1);
        }
        
        for(char c: Y.toCharArray()){
            int num = c - '0';
            int count = map.getOrDefault(num, 0);
            // 존재하는 경우
            if(count > 0) {
                result.add(num);
                map.put(num, map.getOrDefault(num , 0) - 1);
            }
        }
        
        if(result.size() == 0) {
            answer = "-1";
        } else {
            Collections.sort(result, Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for(int num: result) sb.append(num);
            answer = sb.toString();
            if(answer.charAt(0) == '0'){
                answer = "0";
            }

        }
        
        return answer;
    }
}