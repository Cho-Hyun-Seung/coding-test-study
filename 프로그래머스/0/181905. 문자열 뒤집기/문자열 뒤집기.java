class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        StringBuffer sub_str = new StringBuffer(my_string.substring(s,e+1)).reverse();
        answer += my_string.substring(0,s) + sub_str.toString() + my_string.substring(e+1); 
        return answer;
    }
}