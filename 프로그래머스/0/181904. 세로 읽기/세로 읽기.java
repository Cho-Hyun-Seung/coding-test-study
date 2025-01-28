/*
1 2 3 4
5 6 7 8

*/

class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        while(c <= my_string.length()){
            answer += my_string.charAt(c-1);
            c += m;
        }
        return answer;
    }
}