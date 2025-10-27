import java.util.*;
/*
    - t초 동안 붕대를 감으면서 1초 마다 x만큼 체력 회복
    - t초 연속으로 붕대 감으면 y만큼 추가 회복
    - bandage : 시전 시간, 초당 회복량, 추가 회복량 [t, x, y]
    - attacks : 공격 시간, 피해량
*/

class Solution {
    int MAX_HP;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        MAX_HP = health;
        int curHp = MAX_HP;
        int prevTime = 0;
        for(int[] atk : attacks){
            int atkTime = atk[0];
            int damage = atk[1];
            
            // 지난 시간 동안 회복 하기
            int usingTime = atkTime - prevTime;
            int recover = usingTime * x + (int) Math.floor(usingTime / t) * y;
            curHp = Math.min(MAX_HP, curHp + recover);
            
            
            // 대미지 받기
            prevTime = atkTime + 1;
            curHp -= damage;
            
            // 받은 데미지로 죽은지 체크하기
            if(curHp <= 0){
                return -1;
            }
        }
        return curHp;
    }
}