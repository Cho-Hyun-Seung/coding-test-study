import java.util.*;

class Solution {
    static int[] ryan = new int[11];
    static int[] info;
    static int[] best;
    static int gap = 0;
    
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        
        this.info = info;
        
        getScore(10, n);
        
        if(gap == 0) return new int[]{-1};
        
        return best;
    }
    
    public void print(int rScore, int aScore){
        for(int i = 0; i <= 10; i++){
            System.out.print(ryan[i] + " ");
        }
        System.out.print("r : " + rScore + " a : " + aScore);
        System.out.println();
    }
    
    public void getScore(int score, int arrow){
        // 종료 조건
        if(arrow == 0 || score == 0){
            // 화살 0에 다 넣기
            if(arrow > 0) ryan[10] += arrow;
            
            // 점수 계산하기
            calc();
            if(arrow > 0) ryan[10] -= arrow;
            return;
        }
        
        // 이번 라운드에 점수를 가져가는 경우
        int need = info[10 - score] + 1;
        if(arrow >= need){
            ryan[10 - score] += need;
            getScore(score - 1, arrow - need);
            ryan[10 - score] -= need;
        }
        
        // 이번 라운드 점수를 스킵하는 경우
        getScore(score - 1, arrow);
        
        
        // 이번 라운드는 넘어가는 경우
    }
    
    public void calc(){
        int rScore = 0;
        int aScore = 0;
        
        for(int i = 0; i <= 10; i++){
            if(info[i] == 0 && ryan[i] == 0) continue;
            if(info[i] >= ryan[i]){
                aScore += 10 - i;
            } else{
                rScore += 10 - i;
            }
        }
        
        int curGap = rScore - aScore;
        
        if(curGap > gap) {
            gap = curGap;
            best = ryan.clone();
        } else if(gap > 0 && curGap == gap) {
            for(int i = 10; i >= 0; i--){
                // 낮은 점수를 더 많이 맞춘 경우
                if (best[i] == ryan[i]) continue;
                if (ryan[i] > best[i]) {
                    best = ryan.clone();
                } 
                break;
            }
        }
    }
}