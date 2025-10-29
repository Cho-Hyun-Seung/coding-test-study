import java.util.*;
/*
    - 각 포인트 1 ~ n
    - 운송 경로는 m개의 포인트로 구성
    - 운송 로봇 x대, 0초에 동시에 출발
    - 다음 포인트로 이동할 때는 항상 최단 경로로 이동
        => r좌표 변화가 우선!
    - 마지막 포인트 도착 시, 물류 센터 탈출
    
    !!! 이동중 같은 좌표 로봇 2대 이상 시 위험상황 !!!
    - 모든 로봇 운송 마칠 때까지 발생하는 위험한 상황 횟수 return
*/
class Solution {
    Map<Integer, Integer> pointMap;
    Map<Integer, int[]> time;
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        pointMap = new HashMap<>();
        time = new HashMap<>();
        
        // 포인트 찍어 주기
        for(int i = 0; i < points.length; i++){
            int r = points[i][0];
            int c = points[i][1];
            int coord = r * 1000 + c;
            pointMap.put(i + 1, coord);
        }

        int maxTracking = 1;
        for (int[] r : routes) {
            int t = 1;
            for (int k = 0; k < r.length - 1; k++) {
                int start = pointMap.get(r[k]);
                int end = pointMap.get(r[k + 1]);
                int sR = start / 1000, sC = start - sR * 1000;
                int eR = end / 1000, eC = end - eR * 1000;
                
                int steps = Math.abs(eR - sR) + Math.abs(eC - sC);

                t += steps + (k == 0 ? 1 : 0);
            }
            maxTracking = Math.max(maxTracking, t);
        }

        // 루트 그리기
        for(int[] r : routes){
            int[] trackingBox = new int[]{1}; // 절대 시간(모든 로봇 공통 1부터 시작)
            int hitSum = 0;
            for (int k = 0; k < r.length - 1; k++) {
                int start = pointMap.get(r[k]);
                int end = pointMap.get(r[k + 1]);
                hitSum += moveRobot(start, end, trackingBox, k == 0, maxTracking);
            }
            answer += hitSum;
        }
        
        return answer;
    }

    private int moveRobot(int start, int end, int[] trackingBox, boolean includeStart, int maxTracking){
        int sR = start / 1000;
        int sC = start - sR * 1000;
        int eR = end / 1000;
        int eC = end - eR * 1000;

        int hit = 0;
        int tracking = trackingBox[0];

        int moveR = eR - sR;
        int moveC = eC - sC;

        if (moveR == 0) {
            if (includeStart) {
                hit += visitLogic(start, tracking, maxTracking);
                tracking += 1;
            }
        } else if (moveR > 0){
            int startDelta = includeStart ? 0 : 1;
            for(int i = startDelta; i <= moveR; i++){
                int coord = start + i * 1000;
                hit += visitLogic(coord, tracking, maxTracking);
                tracking += 1;
            }
        } else {
            int startDelta = includeStart ? 0 : -1;
            for(int i = startDelta; i >= moveR; i--){
                int coord = start + i * 1000;
                hit += visitLogic(coord, tracking, maxTracking);
                tracking += 1;
            }
        }

        int now = start + moveR * 1000;

        // c 좌표 이동
        if (moveC > 0){
            for(int i = 1; i <= moveC; i++){
                int coord = now + i;
                hit += visitLogic(coord, tracking, maxTracking);
                tracking += 1;
            }
        } else if (moveC < 0){
            for(int i = -1; i >= moveC; i--){
                int coord = now + i;
                hit += visitLogic(coord, tracking, maxTracking);
                tracking += 1;
            }
        }
        
        trackingBox[0] = tracking;
        return hit;
    }
    
    private int visitLogic(int coord, int tracking, int maxTracking){
        int hit = 0;
        
        // 방문한 적 있을 경우
        if(time.containsKey(coord)){
            int[] log = time.get(coord);
            if (tracking >= log.length) return 0;
            if(log[tracking] == 1) {
                hit += 1;
                log[tracking] = -1;
            } else if(log[tracking] != -1){
                log[tracking] += 1;
            }
        } else {
            int[] log = new int[maxTracking + 2];
            log[tracking] += 1;
            time.put(coord, log);
        }
        
        return hit;
    }
}
