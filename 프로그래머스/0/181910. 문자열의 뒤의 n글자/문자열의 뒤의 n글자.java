class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        int sub_size = my_string.length() - n;
        answer += my_string.substring(sub_size);
        return answer;
    }
}