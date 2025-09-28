class Solution {
    private int maxDiff = 0;
    private int[] info;
    private int[] maxAnswer = null;
    
    public int[] solution(int n, int[] info) {
        int[] answer;
        
        this.info = info;
        answer = new int[11];
        
        bt(0, n, answer);
        if (maxAnswer == null) return new int[]{-1};
        return maxAnswer;
    }
    
    private void bt(int idx, int n, int[] answer){
        // 화살을 다 쓰거나 끝에 도달한 경우
        if(idx == 11 || n == 0){
            // 화살 남으면 0점에 꽃아서 동점인 경우 계산하기
            if(n > 0) answer[10] += n;
            
            int diff = calculateDiff(answer);
            
            if(diff > 0){
                if(diff > maxDiff){
                    maxDiff = diff;
                    maxAnswer = answer.clone();
                } else if(diff == maxDiff){
                    if(samePoint(answer)){
                        maxAnswer = answer.clone();
                    }
                }
            }
            
            if (n > 0) answer[10] -= n;
            return;
        }
        
        // 점수 가져가는 경우
        int shoot = info[idx] + 1;
        if(n >= shoot){
            answer[idx] = shoot;
            bt(idx + 1, n - shoot, answer);
            answer[idx] = 0;
        }
        
        // 안 가져가는 경우
        bt(idx + 1, n, answer);
    }
    
    private boolean samePoint(int[] answer){
        for(int i = 10; i >= 0; i--){
            if(answer[i] != maxAnswer[i]){
                return answer[i] > maxAnswer[i];
            }
        }
        
        return false;
    }
    
    private int calculateDiff(int[] answer){
        int apeach = 0;
        int lion = 0;
        
        for(int i = 0; i <= 10; i++){
            int score = 10 - i;
            
            if(answer[i] == 0 && info[i] == 0) continue;
            
            if(answer[i] > info[i]){
                lion += score;
            } else{
                apeach += score;
            }
        }
        
        return lion - apeach;
    }
}