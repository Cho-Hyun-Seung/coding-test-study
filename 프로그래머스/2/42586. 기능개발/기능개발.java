import java.util.*;

/*
    먼저 배포되어야 하는 순서대로 작업의 진도가 적힌정수 배열 progresses
    작업의 개발속도가 적힌 정수 배열 speed
    
    각 배포마다 몇 개의 기능이 배포되는지 return
*/
class Solution {
    private static Deque<Node> deque;
    
    private class Node{
        int progress;
        int speed;
        
        Node(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        deque = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++){
            deque.offerFirst(new Node(progresses[i], speeds[i]));
        }
        
        while(!deque.isEmpty()){
            answer.add(deploy());
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int deploy(){
        int result = 1; // 최소 1개 배포
        
        // 걸리는 시간 계산하기
        // 100 - (0번 노드 prgress)/speed = X 
        Node doFirst = deque.pollLast();
        int day = (int)Math.ceil((100 - doFirst.progress)/(double)doFirst.speed);
        
        while(!deque.isEmpty()){
            Node next = deque.peekLast();
            int curProgress = next.progress + next.speed * day;
            
            if(curProgress >= 100){
                deque.pollLast();
                result += 1;
            } else{
                break;
            }
        }
        return result;
    }
}