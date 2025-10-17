import java.util.*;
/*
    - 글자수가 적은 주문부터 먼저 기록
    - 글자 수가 같다면 사전 순서대로 기록
    - 삭제가 완료된 주문서에서 n번째 주문 찾기
*/

class Solution {
    private int[] spell;
    public String solution(long n, String[] bans) {
        String answer = "";
        
        int before = 0;
        
        Arrays.sort(bans, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length() == b.length()){
                    return a.compareTo(b);
                }
                return a.length() - b.length();
            }
        });
        
        for(String ban: bans){
            long toNum = 0;
            // 3진수를 10진수로 바꾸는법? 위치 값 * 3^위치
            // 현재는 26 진수
            for(int i = ban.length() - 1; i >= 0; i--){
                toNum += (ban.charAt(i) - 'a' + 1) 
                    * Math.pow(26, ban.length()- i - 1);
            }
            // n + 스킵한 수
            if(toNum <= n + before){
                before += 1;
            }
        }

        // 값 찾기
        long num = n + before;
        // 10 진수 -> 26진수로 바꾸기
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            num --;
            char ch = (char)((num) % 26 + 'a');
            sb.append(ch);
            num /= 26;
        }
        
        return sb.reverse().toString();
    }
}