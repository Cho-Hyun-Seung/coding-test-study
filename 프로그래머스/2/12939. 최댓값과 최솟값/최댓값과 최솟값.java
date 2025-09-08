import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        List<Integer> list = new ArrayList<>();
        
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list);
        
        sb.append(list.get(0))
            .append(" ")
            .append(list.get(list.size() - 1));
        return sb.toString();
    }
}