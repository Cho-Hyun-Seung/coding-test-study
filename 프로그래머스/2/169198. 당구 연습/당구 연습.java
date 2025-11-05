import java.util.*;
/*
    - 당구공 위치 리스트 주어짐
    - 위치에 순서대로 공을 놓아가며 원쿠션 연습
    - 항상 같은 위치에 공을 놓고 쳐서 리스트에 담긴 공 맞춤
    - 각 목표로 한 공에 맞을 때까지 최소 거리 구하기!
        -> 최소 값의 제곱을 배열에 담아 return!
*/

class Solution {
    private int[][] board;
    private int M, N;
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        this.M = m;
        this.N = n;

        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int ballX = balls[i][0];
            int ballY = balls[i][1];
            int minDist = Integer.MAX_VALUE;

            if (!(startY == ballY && startX > ballX)) {
                minDist = Math.min(minDist, leftSide(startX, startY, ballX, ballY));
            }

            if (!(startY == ballY && startX < ballX)) {
                minDist = Math.min(minDist, rightSide(startX, startY, ballX, ballY));
            }

            if (!(startX == ballX && startY < ballY)) {
                minDist = Math.min(minDist, upSide(startX, startY, ballX, ballY));
            }

            if (!(startX == ballX && startY > ballY)) {
                minDist = Math.min(minDist, downSide(startX, startY, ballX, ballY));
            }

            answer[i] = minDist;
        }

        return answer;
    }
    
    // 시작 좌표y 축 대칭 이동 시키기
    private int leftSide(int stdX, int stdY, int ballX, int ballY){
        stdX = stdX * -1;
        
        return getDist(stdX, stdY, ballX, ballY);
    }
    
    // m 기준으로 대칭이동하기
    private int rightSide(int stdX, int stdY, int ballX, int ballY){
        stdX = M + (M - stdX);
        
        return getDist(stdX, stdY, ballX, ballY);
    }
    
    // N 기준 대칭 이동
    private int upSide(int stdX, int stdY, int ballX, int ballY){
        stdY = N + (N - stdY);
        
        return getDist(stdX, stdY, ballX, ballY);
    }
    
    private int downSide(int stdX, int stdY, int ballX, int ballY){
        stdY = stdY * -1;
        
        return getDist(stdX, stdY, ballX, ballY);
    }
    
    private int getDist(int stdX, int stdY, int ballX, int ballY){
        int x = Math.abs(stdX - ballX);
        int y = Math.abs(stdY - ballY);
        return (int)(Math.pow(x, 2) + Math.pow(y, 2));
    }
}