// x가 짝수 일 때? x /= 2
// x가 홀수 일 때? x = 3 * x +1
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        while(n!=1){
            answer.add(n);
            n = n %2 == 0 ? n/2 : 3*n +1;
        }
        answer.add(1);
        return answer.stream().mapToInt(v -> v).toArray();
    }
}