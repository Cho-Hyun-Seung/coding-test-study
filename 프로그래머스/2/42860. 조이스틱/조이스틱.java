import java.util.*;

class Solution {
    private static char[] nameArr;
    
    public int solution(String name) {
        int answer = 0;
        
        nameArr = name.toCharArray();
        answer = upDown() + turn();
        
        return answer;
    }
    
    private int upDown(){
        int count = 0;
        
        for(char c: nameArr){
            count += Math.min(c - 'A', 26 - (c - 'A'));
        }
        
        return count;
    }
    
    private int turn(){
        int count = nameArr.length - 1;
        
        for(int i = 0; i < nameArr.length; i ++){
            int next = i + 1;
            // 돌아가는 경우 정하기
            while(next < nameArr.length && nameArr[next] == 'A'){
                next += 1;
            }
            
            // 우로 돌아갔을 때랑 count 비교해서 최소 값 정하기
            count = Math.min(count, i*2 + nameArr.length - next);
            
            // 좌로 돌아갔을 때
            count = Math.min(count, (nameArr.length - next) * 2 + i);
        }
        return count;
    }

    
}