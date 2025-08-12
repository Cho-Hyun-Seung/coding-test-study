import java.util.*;

class Solution {
    private static PriorityQueue<Integer> queue;
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 오름 차순 정렬
        queue = new PriorityQueue<>((a, b) -> a-b);
        
        // 스코빌 지수 넣어주기
        for(int i = 0; i < scoville.length; i++){
            queue.offer(scoville[i]);
        }

        // 앞에 두 개 값 더해서 넣어 주기
        while(true){
            // 큐에 1개만 남은 경우 => 밖에서 조건 체크하기
            if(queue.size() == 1){
                break;
            }
            int last = queue.poll();
            // 가장 낮은 스코빌이 K보다 크거나 같은 경우
            if(last >= K){
                return answer;
            }
            
            int secondLast = queue.poll();
            
            queue.offer(last + (secondLast * 2));
            answer += 1;
        }
        
        return queue.poll() >= K ? answer : -1;
    }
}