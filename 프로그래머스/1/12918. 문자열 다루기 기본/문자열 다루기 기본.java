class Solution {
    public boolean solution(String s) {
        try{
            if(!(s.length() == 4 || s.length() == 6)){
                throw new RuntimeException();
            }
            Long.parseLong(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}