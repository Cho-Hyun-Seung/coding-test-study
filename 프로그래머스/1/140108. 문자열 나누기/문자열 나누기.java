class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char target = s.charAt(0);
        int same = 1;
        int diff = 0;
        for(int i = 1; i < s.length(); i++){
            // 동일 여부 판단
            if(s.charAt(i) == target){
                same += 1;
            } else {
                diff += 1;
            }
            
            // 동일해진 경우
            if(same == diff){
                answer += 1;
                if(i < s.length() - 1){
                    target = s.charAt(i + 1);
                    i += 1;
                    same = 1;
                    diff = 0;
                }
            }
        }
        
        if(same != diff) answer += 1;
        
        return answer;
    }
}