import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        char[] chArr = s.toCharArray();
        String str = "";
        for(char ch: chArr){
            // 숫자인 경우
            if(ch >= '0' && ch <= '9'){
                sb.append(ch);
                continue;
            }
            str += ch;
            // 영단어가 완성된 경우
            if(map.containsKey(str)){
                sb.append(map.get(str));
                str = "";
            }
        }
        int answer = Integer.parseInt(sb.toString());
        return answer;
    }
}