import java.util.*;
/*
    - if 작업을 하지 X
        가장 우선순위 높은 것
        (작업 소요시간 > 요청 시각 > 작업 번호)
*/
class Solution {
    private static PriorityQueue<int[]> pq;
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 처음 시작할 jobs 찾기용
        Arrays.sort(jobs, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        pq = new PriorityQueue<>((a, b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int N = jobs.length;
        int doneJobs = 0;
        int idx = 0;
        int time = 0;
        
        
        while(doneJobs < N){
            // 1. 현재 시각에 수행 가능한 job pq에 입력
            while (idx < N && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }
            
            // 2. 현재 시각에 가능한 job이 없는 경우
            if(pq.isEmpty()){
                time = Math.max(time, jobs[idx][0]);
                continue;
            }
            
            // 3. jobs이 진행 가능한 경우
            int[] job = pq.poll();
            time += job[1];
            doneJobs += 1;
            answer += time - job[0];
        }
        
        return answer/N;
    }
}