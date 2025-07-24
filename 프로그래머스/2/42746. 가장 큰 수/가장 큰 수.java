import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] strArr = Arrays.stream(numbers)
            .boxed()
            .map(String::valueOf)
            .toArray(String[]::new);
        
        Arrays.sort(strArr, (a,b) -> (b+a).compareTo(a+b));
        
        if(strArr[0].charAt(0) == '0'){
            return "0";
        }
        
        answer = String.join("",strArr);
        
        return answer;
    }
}