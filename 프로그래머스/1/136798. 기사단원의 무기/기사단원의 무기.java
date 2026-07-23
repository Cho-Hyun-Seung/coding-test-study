class Solution {
    public int solution(int number, int limit, int power) {
        if(number == 1) return 1;
        int answer = 3;
        
        for(int i = 3; i <= number; i++) {
            int num = getPrime(i);
            if(num > limit) {
                answer += power;
            } else {
                answer += num;
            }
        }
        
        return answer;
    }
    
    private int getPrime(int number){
        int result = 0;
        
        for(int i = 1; i <= Math.sqrt(number); i++){
            if(i * i == number){
                result += 1;
            } else if( number % i == 0) {
                result += 2;
            }
        }
        return result;
    }
}