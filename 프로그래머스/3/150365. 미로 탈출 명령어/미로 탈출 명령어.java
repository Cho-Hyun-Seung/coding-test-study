import java.util.*;

class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] dir = {'d','l','r','u'};

    static int n, m, x, y, r, c, k;
    static StringBuilder sb = new StringBuilder();
    static String answer = null;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        Solution.n = n;
        Solution.m = m;
        Solution.x = x;
        Solution.y = y;
        Solution.r = r;
        Solution.c = c;
        Solution.k = k;

        int length = distance(x, y);
        if((k - length) % 2 == 1 || k < length) return "impossible";

        dfs(0, x, y);
        return answer == null ? "impossible" : answer;
    }

    private static boolean in(int cx, int cy){
        return 1 <= cx && cx <= n && 1 <= cy && cy <= m;
    }

    private static int distance(int cx, int cy){
        return Math.abs(cx - r) + Math.abs(cy - c);
    }

    private static void dfs(int depth, int cx, int cy){
        if (answer != null) return;

        int need = distance(cx, cy);
        int remain = k - depth;

        if (need > remain) return;
        
        if (depth == k) {
            if (cx == r && cy == c) answer = sb.toString();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if (in(nx, ny)) {
                sb.append(dir[i]);
                dfs(depth + 1, nx, ny);
                sb.deleteCharAt(sb.length() - 1);
                if (answer != null) return;
            }
        }
    }
}
