class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        while(left <= right) {
            boolean isOdd = countFactor(left) % 2 == 1;
            
            if(isOdd){
                answer -= left;
            } else {
                answer += left;
            }
            
            left += 1;
        }
        
        return answer;
    }
    
    private final int countFactor(int num){
        int count = 0;
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(i * i == num) {
                count += 1;
            } else if(num % i == 0){
                count += 2;
            }
        }
        
        return count;
    }
}