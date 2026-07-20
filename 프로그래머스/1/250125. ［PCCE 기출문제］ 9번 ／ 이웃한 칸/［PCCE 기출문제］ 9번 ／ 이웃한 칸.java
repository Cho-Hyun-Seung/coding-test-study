class Solution {
    private static int[] dx = {0, 1, -1 ,0};
    private static int[] dy = {1, 0, 0, -1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int N = board.length;
        int count = 0;
        String color = board[h][w];
        
        for(int i = 0; i < 4; i++) {
            int nx = dx[i] + h;
            int ny = dy[i] + w;
            if(nx < N && nx >= 0 && ny < N && ny >= 0){
                if(board[nx][ny].equals(color)){
                    count += 1;
                }
            }
        }
        
        return count;
    }
}