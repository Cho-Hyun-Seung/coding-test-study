import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        List<Integer> indices_list = Arrays.stream(indices).boxed().collect(Collectors.toList());
        for(int i = 0; i < my_string.length(); i++){
            if(!indices_list.contains(i)){
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }
}