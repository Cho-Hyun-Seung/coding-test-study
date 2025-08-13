import java.util.*;

/*
    바탕화면 상태 wallpaper
    - 빈칸 : .
    - 파일 : #
    - 최소한의 이동거리를 갖는 한번의 드래그로 모든 파일 선택
*/

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};

        int maxX = 0;
        int minX = wallpaper[0].length();
        int maxY = 0;
        int minY = wallpaper.length;
        
        // 바탕화면 요소 체크하기
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    maxX = Math.max(maxX, j);
                    minX = Math.min(minX, j);
                    maxY = Math.max(maxY, i);
                    minY = Math.min(minY, i);
                }
            }
        }
        answer = new int[]{minY, minX, maxY + 1, maxX + 1};
        
        return answer;
    }
}