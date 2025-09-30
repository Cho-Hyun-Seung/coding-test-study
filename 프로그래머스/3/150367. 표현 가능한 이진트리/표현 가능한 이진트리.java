import java.util.*;

class Solution {
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            String binNum = toBinary(numbers[i]);
            
            // 노드 수 구하기
            int size = 1;
            
            while(size < binNum.length()){
                size = size * 2 + 1;
            }
            
            // 노드 채우기
            int add = size - binNum.length();
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < add; k++) sb.append('0');
            sb.append(binNum);
            String padded = sb.toString();
            
            // 노드 검사하기
            answer[i] = (check(padded, 0, size - 1) == -1) ? 0 : 1;
        }
        
        return answer;
    }
    
    public String toBinary(long num){
        StringBuilder sb = new StringBuilder();
        
        while(num > 0){
            if(num % 2 == 1){
                sb.append(1);
            } else{
                sb.append(0);
            }
            num /= 2;
        }
        
        return sb.reverse().toString();
    }
    
    private int check(String s, int l, int r) {
        // 리프노드 인 경우
        if (l == r) return s.charAt(l) - '0';
        
        // 루트 노드인 경우
        int m = (l + r) / 2;
        int left = check(s, l, m - 1);
        if (left == -1) return -1;
        
        int right = check(s, m + 1, r);
        if (right == -1) return -1;
        
        int mid = s.charAt(m) - '0';
        
        // 부모가 0인데 자식 중 1이 있으면 불가능
        if (mid == 0 && (left + right) > 0) return -1;
        
        return (left + right + mid) > 0 ? 1 : 0;
    }
}