class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean isOdd = false;
        
        for(String c : s.split("")){
            if(c.equals(" ")){
                isOdd = false;
                sb.append(" ");
                continue;
            }
            
            if(isOdd){
                sb.append(c.toLowerCase());
            } else {
                sb.append(c.toUpperCase());
            }
            isOdd = !isOdd;
        }
        
        return sb.toString();
    }
}