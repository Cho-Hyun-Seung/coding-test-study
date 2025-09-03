import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int cur = routes[0][1];
        
        for(int i = 1; i < routes.length; i++){
            // CCTV 추가 설치가 필요한 경우
            if(cur < routes[i][0]){
                cur = routes[i][1];
                answer += 1;
            } else {    // 추가 설치 필요 없는 경우
                cur = Math.min(cur, routes[i][1]);
            }
        }
        return answer;
    }
}