import java.util.*;
/*
    - 양의 정수 n을 k진수로 바꿧을 때 조건 확인
*/
class Solution {
    public int solution(int n, int k) {
        // 진수 변환 해주기
        String num = changeNumber(n, k);
        
        // 리스트로 조건 만들어주기
        return findPrime(num);
    }
    
    static int findPrime(String number){
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length(); i++){
            if(number.charAt(i) == '0'){
                if(sb.length() > 0){
                    long madeNum = Long.parseLong(sb.toString());
                    if(isPrime(madeNum)){
                        answer += 1;
                    }
                    sb = new StringBuilder();
                }
            } else {
                sb.append(number.charAt(i));
            }
        }
        if(sb.length() > 0){
            long madeNum = Long.parseLong(sb.toString());
            if(isPrime(madeNum)){
                answer += 1;
            }
        }
        
        return answer;
    }
    
    static boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public String changeNumber(int n, int k){
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            sb.append(n % k);
            n /= k;
        }
        
        return sb.reverse().toString();
    }
}