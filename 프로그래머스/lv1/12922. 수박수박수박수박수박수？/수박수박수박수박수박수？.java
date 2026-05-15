class Solution {
    private final String STR = "수박";
    
    public String solution(int n) {
        String answer = "";
        if(n % 2 == 0){
            answer += STR.repeat(n / 2);
        } else {
            answer += STR.repeat(n / 2) + "수";
        }
        return answer;
    }
}