import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int goalAlp = 0, goalCop = 0;
        for (int[] p : problems) {
            goalAlp = Math.max(goalAlp, p[0]);
            goalCop = Math.max(goalCop, p[1]);
        }

        if (alp >= goalAlp && cop >= goalCop) return 0;

        alp = Math.min(alp, goalAlp);
        cop = Math.min(cop, goalCop);

        int[][] dp = new int[goalAlp + 1][goalCop + 1];
        
        for (int i = 0; i <= goalAlp; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[alp][cop] = 0;

        for (int i = alp; i <= goalAlp; i++) {
            for (int j = cop; j <= goalCop; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;

                if (i + 1 <= goalAlp) 
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                if (j + 1 <= goalCop) 
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                for (int[] p : problems) {
                    int reqA = p[0], reqC = p[1], rA = p[2], rC = p[3], cost = p[4];
                    if (i >= reqA && j >= reqC) {
                        int ni = Math.min(goalAlp, i + rA);
                        int nj = Math.min(goalCop, j + rC);
                        dp[ni][nj] = Math.min(dp[ni][nj], dp[i][j] + cost);
                    }
                }
            }
        }

        return dp[goalAlp][goalCop];
    }
}
