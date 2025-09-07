import java.util.*;
/*
    - 프로세스 중요도 순서로 담긴 배열 priorities
    - 몇 번 째로 실행되는지 알고 싶은 프로세스 위치 location ( 0 ~ n-1 )
*/
class Solution {
    
    class Node{
        int location;
        int priority;
        
        Node(int location, int priority){
            this.location = location;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] copyArr = priorities.clone();
        Arrays.sort(copyArr);
        
        int idx = copyArr.length - 1;
        
        Queue<Node> queue = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            queue.offer(new Node(i, priorities[i]));
        }
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            // 가장 우선순위가 높은지 확인
            if(cur.priority == copyArr[idx]){
                if(cur.location == location){
                    break;
                }
                idx--;
                continue;
            } else {
                queue.offer(cur);
            }
        }
        
        return priorities.length - idx;
    }
}