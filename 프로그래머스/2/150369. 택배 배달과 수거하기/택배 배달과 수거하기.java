import java.util.*;
/*
    - 일렬로 나열된 n개의 집에 택배 배달
    - i번째 집은 거리가 i만큼 떨어짐
    - 트럭에 cap개 실을 수 있음
    - 각 집에 배달, 수거할 때, 원하는 개수만큼 배달 수거 가능
    
    return 트럭 하나로 모든 배달, 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리
*/
class Solution {
    static int n;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        this.n = n;
        
        int go = n - 1;
        int back = n - 1;
        
        
        // 갈때는 배달만하고, 올 때 수거?
        while (true) {
            while (go >= 0 && deliveries[go] == 0) go--;
            while (back >= 0 && pickups[back] == 0) back--;

            if (go < 0 && back < 0) break;
            int length = Math.max(go, back) + 1;
            answer += length * 2L;
            
            int cur = cap;
            while (go >= 0 && cur > 0) {
                if (deliveries[go] == 0) { go--; continue; }
                int take = Math.min(cur, deliveries[go]);
                deliveries[go] -= take;
                cur -= take;
                if (deliveries[go] == 0) go--;
            }

            // 수거 처리
            cur = cap;
            while (back >= 0 && cur > 0) {
                if (pickups[back] == 0){
                    back -= 1;
                    continue; 
                }
                
                int take = Math.min(cur, pickups[back]);
                pickups[back] -= take;
                cur -= take;
                
                if (pickups[back] == 0) back--;
            }
            
        }
        
        return answer;
    }
}