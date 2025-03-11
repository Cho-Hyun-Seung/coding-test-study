import java.util.*;

class Solution {
    /*
    d : 부서별로 신청한 금액이 들어있는 배열 1 <= len <=100
    budget : 예산
    */
    // 각 부서가 신청한 금액만큼을 모두 지원
    // 최대 몇 개의 부서에 물품을 지원할수 있는지 return
    public int solution(int[] d, int budget) {
        int answer = 0;
        // 정렬해서 가장 낮은 지원금 요구하는 곳 부터 지원해주기!
        Arrays.sort(d);
        for(int money : d){
            budget -= money;
            if(budget < 0){
                break;
            }
            answer +=1;
        }
        
        
        return answer;
    }
}