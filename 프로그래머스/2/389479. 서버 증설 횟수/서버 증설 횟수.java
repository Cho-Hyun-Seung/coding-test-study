import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int T = players.length;
        int answer = 0;
        int active = 0;
        int[] added = new int[T];

        for (int t = 0; t < T; t++) {
            if (t - k >= 0) {
                active -= added[t - k];
            }
            
            int required = players[t] / m;

            if (required > active) {
                int need = required - active;
                added[t] = need;
                active += need;
                answer += need;
            }
        }

        return answer;
    }
}