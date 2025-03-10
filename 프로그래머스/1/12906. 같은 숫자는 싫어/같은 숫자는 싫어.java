import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(list.size() == 0) {
                list.add(arr[i]);
                continue;
            }
            if(list.get(list.size() - 1) == arr[i]){
                continue;
            }
            list.add(arr[i]);

        }
        answer = list.stream().mapToInt(v -> v).toArray();
        return answer;
    }
}