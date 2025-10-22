import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        
        int count = 0;
        int[] dh = {0, -1, 1 ,0};
        int[] dw = {1, 0, 0, -1};
        for(int i = 0; i < 4; i++){
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            
            if(valid(h_check, w_check, n) && board[h_check][w_check].equals(board[h][w])){
                count += 1;
            }
            
        }
        
        return count;
    }
    
    public boolean valid(int h, int w, int n){
        return h >= 0 && h < n && w >= 0 && w < n;
    }
}