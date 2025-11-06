import java.util.*;
/*
    - col, row begin, row end 입력
    - 튜플을 col 번째 컬럼의 값을 기준으로 오른차순 정렬
*/
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, ((o1, o2) -> 
                           o1[col - 1] != o2[col - 1] 
                           ? o1[col - 1] - o2[col - 1] 
                           : o2[0] - o1[0]));

        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int S_i = 0;
            // 각 컬럼을 i+1로 나눈 값을 더함
            for (int d : data[i]) S_i += (d % (i + 1));
            // XOR 누적
            answer = (answer ^ S_i);
        }

        return answer;
    }
}