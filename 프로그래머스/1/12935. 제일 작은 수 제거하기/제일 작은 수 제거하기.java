import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        
        List<Integer> list = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());
        
        list.remove(Collections.min(list));
        
        
        answer = list.size() == 0
            ? new int[]{-1}
            : list.stream().mapToInt(v -> v).toArray();
        
        return answer;
    }
}