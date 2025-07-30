import java.util.*;

class Solution {
    private static boolean[] visited;
    private static int maxCount;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        maxCount = 0;

        dfs(dungeons, k, 0);
        return maxCount;
    }

    private void dfs(int[][] dungeons, int k, int count) {
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < dungeons.length; i++) {
            // 방문하지 않은 곳 방문하기
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, k - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}
