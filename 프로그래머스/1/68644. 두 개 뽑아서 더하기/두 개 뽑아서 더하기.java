import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        answer = set.stream()
            .mapToInt(v->v)
            .sorted()
            .toArray();
        return answer;
    }
}