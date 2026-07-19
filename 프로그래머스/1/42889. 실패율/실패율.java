import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {        
        // 1. 스테이지별 도전자 수
        int[] challenger = new int[N + 2];
        
        for(int stage: stages){
            challenger[stage] += 1;
        }
        
        // 2. 실패율 계산
        double[] failure = new double[N + 1];
        int rest = stages.length;
        for(int i = 1; i <= N; i++){
            if(rest == 0){
                failure[i] = 0;
            } else {
                failure[i] = (double) challenger[i] / rest; 
            }
            
            rest -= challenger[i];
        }
        
        // 3. 스테이지 정렬
        Integer[] answer = new Integer[N];
        for(int i = 0; i < N; i++){
            answer[i] = i + 1;
        }
        
        Arrays.sort(answer, (a, b) -> {
            // 실패율이 같은 경우, 내림차순
            int compare = Double.compare(failure[b], failure[a]);
            
            if(compare == 0) return Integer.compare(a, b);
            
            return compare;
        });
        
        return Arrays.stream(answer)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}