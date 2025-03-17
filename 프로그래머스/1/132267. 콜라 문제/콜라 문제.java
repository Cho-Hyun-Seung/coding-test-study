class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        // 빈 병 a 개를 가져다 주면 콜라 b 병을 주는 마트가 존재
        while(true){
            // a개를 주면 b개 돌려줌
            int reGet =  n / a * b;
            // 나머지 + 돌려받은 콜라 수
            n = (n % a) + reGet;
            answer += reGet;
            if(n < a){
                break;
            }
        }
        
        // 빈 병 n 개를 가져다주면 몇 병을 받을 수 있는지 계산하시오!
        return answer;
    }
}