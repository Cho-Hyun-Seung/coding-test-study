class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int dir = 0;
        int x = 0, y = 0;
        answer[0][0] = 1;
        
        while(num < n * n){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && answer[ny][nx] == 0){
                answer[ny][nx] = ++num;
                x = nx;
                y = ny;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        
        return answer;
    }
}
