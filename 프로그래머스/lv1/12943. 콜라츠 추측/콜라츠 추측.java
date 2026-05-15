class Solution {
    int count = 0;
    
    public long solution(int num) {
        if(num == 1) return 0;
        long answer = collatz(num);
        return answer;
    }
   
    private long collatz(long num){
        if(count >= 500) return -1;

        if(num % 2 == 0){
            num /= 2;
        } else {
            num = num * 3 + 1;
        }
        count += 1;

        return num == 1 ? count : collatz(num);
    }
    
}