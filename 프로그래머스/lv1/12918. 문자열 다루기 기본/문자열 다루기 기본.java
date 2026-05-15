class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        try {
            int num = Integer.valueOf(s);
            
            if(s.length() != 4 && s.length() != 6){
                throw new Exception();
            }
            return true;
        } catch(Exception e){
            return false;
        }
    }
}