import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i=0; i<10; i++){
            for(int j=0; j<want.length; j++){
                if(discount[i].equals(want[j])) number[j]--;
            }
        }
        
        boolean isEmpty = true;
        for(int j=0; j<number.length; j++){
            if(number[j]!=0) isEmpty=false;    
        }
        if(isEmpty) answer++;
    
        
        // 10일부터 하루씩 반복문 
        for(int i=10; i<discount.length; i++){
            
            // 그 전 물건 초기화
            for(int j=0; j<want.length; j++){
                if(discount[i-10].equals(want[j])) number[j]++;
                if(discount[i].equals(want[j])) number[j]--;
            }
            
            isEmpty = true;
            for(int j=0; j<number.length; j++){
                if(number[j]!=0) {
                    isEmpty=false;
                }
            }
            if(isEmpty) answer++;
        }
        
        
        return answer;
    }
}