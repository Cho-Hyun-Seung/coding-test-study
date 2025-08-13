import java.util.*;
/*
    출근 희망 시각 + 10분 까지 어플로 출근
    토, 일의 출근 시각은 이벤트 영향 X
    모든 시각은 시에 100곱하고 분을 더한 정수로 표현
    -> 상품을 받을 직원 수 return
*/
/*
    schedules : 출근 희망 시각
    timelogs  : 실제 출근 시각
    startday  : 시작 요일
*/
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        // 주말 계산하는 법 : startday + 5 % 7,  startday + 6 % 7 
        int startIndex = startday - 1;
        int satIdx = (7 - startIndex + 5) % 7;
        int sunIdx = (7 - startIndex + 6) % 7;

        for(int i = 0; i < schedules.length; i++){
            if(getPresent(schedules[i], timelogs[i], satIdx, sunIdx)){
                answer += 1;
            }
        }
        return answer;
    }
    
    private boolean getPresent(int schedule, int[] timelog, int satIdx, int sunIdx){
        int scheduleH = schedule / 100;
        int scheduleM = schedule % 100;
            
        // 출근 인정 시각 만들기
        int deadlineM = scheduleH * 60 + scheduleM + 10;
        
        for(int i = 0; i < timelog.length; i++){
            // 주말이면 건너뛰기
            if(i == satIdx || i == sunIdx){
                continue;
            }
            int logH = timelog[i] / 100;
            int logM = timelog[i] % 100;
            int memberM = logH * 60 + logM;
            
            if(memberM > deadlineM) return false;
        }
        return true;
    }
}