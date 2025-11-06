import java.util.*;
/*
    - n명을 가지고 있음
    - 매 라운드마다 enemy[i] 마리의 적이 등장
    - 남은 병사 중 등장 수만큼 소모하여 적을 막을 수 있음
    - 무적권 사용시 병사 소모 X -> K번 사용 가능
*/

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        
        for (int i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);
            sum += enemy[i];
            
            if (sum > n) {
                if (k > 0) {
                    sum -= pq.poll();
                    k--;
                } else {
                    return i;
                }
            }
        }
        return enemy.length;
    }
}