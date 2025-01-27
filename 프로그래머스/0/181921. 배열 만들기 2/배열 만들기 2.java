import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        
        int i = 1;
        while (true) {
            String bin_i = Integer.toBinaryString(i);
            
            int bin_to_dec = Integer.parseInt(bin_i) * 5;
            
            if (bin_to_dec > r) break; // 범위를 초과 시 종료
            
            if (bin_to_dec >= l) {
                answer.add(bin_to_dec);
            }
            
            i++;
        }  
        if (answer.size() == 0) {
            return new int[]{-1};
        } else {
            return answer.stream().mapToInt(v -> v).toArray();
        }
    }
}
