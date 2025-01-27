class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int temp = numLog[0];
        for(int i = 1; i < numLog.length; i++){
            switch(numLog[i] - temp){
                case 1:
                    answer += "w";
                    break;
                case -1:
                    answer += "s";
                    break;
                case -10:
                    answer += "a";
                    break;
                case 10:
                    answer += "d";
                    break;
                default:
                    break;
            }
            temp = numLog[i]; // temp 값 변경
        }
        return answer;
    }
}