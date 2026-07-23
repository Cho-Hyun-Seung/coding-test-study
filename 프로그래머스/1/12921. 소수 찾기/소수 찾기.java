class Solution {
  
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 2; i <= n; i++){
            answer += isPrimary(i) ? 1 : 0;
        }
        
        return answer;
    }
    
    public boolean isPrimary(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}