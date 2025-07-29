import java.util.*;
/*
    노랑이 안쪽, 갈색이 테두리
    가로 >= 세로
    ! 가로와 세로의 길이 경우의 수를 나눠서 채우기
*/
class Solution {
    
    
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        // yellow 경우의 수 찾아주기
        for(int height = 1; height <= Math.sqrt(yellow); height++){
            // 나머지가 0인 경우
            if(yellow % height == 0){
                if(wrapBrown(brown, yellow/height, height)){
                    answer = new int[]{yellow/height + 2, height + 2};
                    break;
                }
            }
        }
        
        return answer;
    }
    
    private boolean wrapBrown(int brown, int width, int height){
        return brown == (width + 2) * 2 + height * 2;
    }
}

