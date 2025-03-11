import java.util.*;
class Solution {
    
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] charArr = s.toCharArray();
        List<Character> list = new ArrayList<>();
        
        for(int i = 0; i < charArr.length; i++){
            char ch = s.charAt(i);
            int idx = 0;
            boolean isExists = false;
            // 리스트에 존재하는지 확인
            for(char listCh: list){
                idx++;
                if(ch == listCh){
                    isExists = true;
                    answer[i] = idx;
                    break;
                }
            }
            list.add(0, ch);
            if(!isExists) answer[i] = -1;
        }
        
        return answer;
    }
}