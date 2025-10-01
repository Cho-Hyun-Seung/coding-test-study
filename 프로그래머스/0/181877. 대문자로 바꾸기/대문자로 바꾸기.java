class Solution {
    public String solution(String myString) {
        String answer = "";
        char[] charArray = myString.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : charArray){
            if(c >= 'A' && c <= 'Z'){
                sb.append(c);
            } else{
                sb.append(Character.toString(c - 32));
            }
        }
        return sb.toString();
    }
}