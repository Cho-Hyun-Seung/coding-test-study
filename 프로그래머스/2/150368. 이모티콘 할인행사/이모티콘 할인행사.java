import java.util.*;
/*
    목표. 사용자 최대 > 판매액 최대
    
    사용자 구매 기준
    - 자신의 기준에 따라 일정 비율 이상 할인하는 이모티콘 모두 구매
    - 이모티콘 구매 비용 합이 일정 이상이면 이모티콘 플러스 가입
    
    return
    - 가입 수, 이모티콘 매출액
*/

class Solution {
    // 할인율 배열
    private static int[] rate = {10, 20, 30 ,40};
    private static int[] emoticons;
    private static int[][] users;
    private int maxPassUser = 0;
    private int maxRevenue = 0;
    
    private static int[] discount;
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        int[] answer = {};
        
        discount = new int[emoticons.length];
        
        bt(0);
        return new int[]{maxPassUser, maxRevenue};
    }
    
    // 경우의 수 생성
    private void bt(int idx){
        if(idx == emoticons.length){
            result();
            return;
        }
        
        for(int r: rate){
            discount[idx] = r;
            bt(idx + 1);
        }
    }
    
    
    private void result(){
        int passUser = 0;
        int revenue = 0;
        
        for(int[] user : users){
            int userDiscount = user[0];
            int passLine = user[1];
            
            int sum = 0;
            for(int i = 0; i < emoticons.length; i++){
                // 구매하는 경우
                if(discount[i] >= userDiscount){
                    sum += emoticons[i] * (100 - discount[i]) / 100;
                }
            }
            
            if(sum >= passLine) {
                passUser += 1;
            } else {
                revenue += sum;
            }
        }
        
        if(passUser > maxPassUser){
            maxPassUser = passUser;
            maxRevenue = revenue;
        } else if(passUser == maxPassUser && revenue > maxRevenue) {
            maxRevenue = revenue;
        }
    }
    
}