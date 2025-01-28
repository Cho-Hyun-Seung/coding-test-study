import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        System.out.println('a' +0);
        System.out.println('A' +0);
        for(int i = 0; i < 26; i ++){
            int upper_count = 0;
            int lower_count = 0;
            for(char ch:my_string.toCharArray()){
                if(ch-65 == i){
                    upper_count +=1;
                }
                if(ch-97 == i){
                    lower_count +=1;
                }
            }
            answer[i] = upper_count;
            answer[i+26] = lower_count;
        }
        return answer;
    }
}