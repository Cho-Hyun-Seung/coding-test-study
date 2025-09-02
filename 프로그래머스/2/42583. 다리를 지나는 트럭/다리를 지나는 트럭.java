import java.util.*;
/*
    다리 최대 하중 weight
    다리 최대 개수 bridge_length
*/
class Solution {
    static Queue<Integer> bridge;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        bridge = new LinkedList<>();
        
        int nowWeight = 0;
        int time = 0;
        int idx = 0;
        
        for(int i = 0; i < bridge_length; i++){
            bridge.offer(0);
        }
        
        while(idx < truck_weights.length){
            time += 1;
            
            nowWeight -= bridge.poll();
            
            if(nowWeight + truck_weights[idx] <= weight){
                bridge.add(truck_weights[idx]);
                nowWeight += truck_weights[idx];
                idx += 1;
            } else{
                bridge.add(0);
            }
        }
        answer = time + bridge_length;
        
        return answer;
    }
}