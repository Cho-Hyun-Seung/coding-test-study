import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        List<Character> list = new ArrayList<>();
        
        char alpha = 'a';
        
        for(int i = 0; i < 26; i++){
            if(!skip.contains(String.valueOf(alpha))){
                list.add(alpha);
            }
            alpha += 1;
        }

        StringBuilder answer = new StringBuilder();
        System.out.println(list.size());
        int ROTATE = list.size();
        for(char c : s.toCharArray()){
            if(list.indexOf(c) + index >= list.size()){
                answer.append(list.get((list.indexOf(c) + index) % ROTATE));
            } else {
                answer.append((list.get(list.indexOf(c) + index)));
            }
        } 
        
        return answer.toString();
    }
}