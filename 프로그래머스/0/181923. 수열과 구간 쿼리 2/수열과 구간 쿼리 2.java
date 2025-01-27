import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            int min_num = Arrays.stream(arr,s,e+1)
                .filter(v -> v > k)
                .min()
                .orElse(-1);
            answer[i] = min_num;
        }
        return answer;
    }
}