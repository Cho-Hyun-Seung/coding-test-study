class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        for(int idx: index_list){
            char ch = my_string.charAt(idx);
            answer += ch;
        }
        return answer;
    }
}