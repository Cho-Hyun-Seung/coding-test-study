import java.util.Arrays;

class Solution {
    public int[] solution(int n, int k) {
        int[] answer = new int[(int)Math.floor(n/k)];
        for(int i = 1; i <= (int)n/k; i++){
            answer[i-1] = k *i;
        }
        return answer;
    }
}