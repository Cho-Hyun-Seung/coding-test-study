import java.util.*;
/*
    - 최소한의 객실만을 사용하여 예약 손님 받음
    - 한번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소 후 다음 손님 사용 가능
*/
class Solution {
    
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for(String[] bt : book_time){
            int start = toMinutes(bt[0]);
            int end = toMinutes(bt[1]);
            
            pq.add(new int[]{start, end});
        }
        int roomCount = 0;
        List<Integer> usingRoom = new ArrayList<>();
        int restRoom = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            // 청소 끝내기
            List<Integer> newUsingRoom = new ArrayList<>();
            for(int r : usingRoom){
                if(cur[0] >= r){
                    restRoom += 1;
                } else {
                    newUsingRoom.add(r);
                }
            }
            
            usingRoom = newUsingRoom;
            
            // 빈 방이 없는 경우
            if(restRoom == 0){
                // 방 개수 추가하기
                roomCount += 1;
            } else {
                // 방 사용하기
                restRoom -= 1;
            }
            usingRoom.add(cur[1] + 10);
        }
        
        
        return roomCount;
    }
    
    public int toMinutes(String time){
        String[] hm = time.split(":");
        
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }
}