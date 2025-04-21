class Solution {
    public long solution(long n) {
        long answer = -1;
        long sqrtValue = (long) Math.sqrt(n);
        
        if(sqrtValue * sqrtValue == n){
            answer = (sqrtValue + 1) * (sqrtValue + 1);
        }
        
        return answer;
    }
}