class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int sumOfNum = sum(x);
        
        answer = x % sumOfNum == 0;
        
        return answer;
    }
    
    public int sum(int num){
        int result = 0;
        
        while(num != 0){
            result += num % 10;
            num /= 10;
        }
        
        return result;
    }
}