import java.util.*;
/*
    - 사용자 입력이 끝난 후 동영상 위치 mm:ss 형태로 출력
    
    - 동영상 길이 veideo_len
    - 기능 수행 지전 재생 위치 pos
    - 오프닝 시작 시간 op_start
        - 현재 재생 위치가 오프닝 구간인 경우 자동으로 오프닝이 끝나는 위치로 이동
    - 사용자 입력 배열 commands
*/
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int videoSec = toSec(video_len);
        int cur = toSec(pos);
        int opStartSec = toSec(op_start);
        int opEndSec = toSec(op_end);
        
        if(cur >= opStartSec && cur <= opEndSec){
            cur = opEndSec;
        }
        
        for(String c : commands){
            
            if(c.equals("next")){
                if(cur + 10 <= videoSec){   // 비디오 길이 이하
                    cur = cur + 10;
                } else {    // 비디오 길이 초과
                    cur = videoSec;
                }
            }
            else if(c.equals("prev")){
                if(cur - 10 >= 0){
                    cur -= 10;
                } else {
                    cur = 0;
                }
            }
            if(cur >= opStartSec && cur <= opEndSec){
                cur = opEndSec;
            }
        }
        
        answer = toMinSec(cur);
        
        return answer;
    }
    
    
    private int toSec(String time){
        String[] arr = time.split(":");
        
        int min = Integer.parseInt(arr[0]);
        int sec = Integer.parseInt(arr[1]);
        
        return min * 60 + sec;
    }
    
    private String toMinSec(int time){
        StringBuilder sb = new StringBuilder();
        
        int min = time / 60;
        int sec = time % 60;
        
        if(min < 10){
            sb.append("0");
        }
        
        sb.append(min).append(":");
        
        if(sec < 10){
            sb.append("0");
        }
        
        sb.append(sec);
        
        return sb.toString();
    }
}