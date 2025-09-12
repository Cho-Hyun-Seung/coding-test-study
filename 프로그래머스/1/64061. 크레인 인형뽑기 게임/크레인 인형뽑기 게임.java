import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int N = board.length;
        
        // 무브 돌기
        for(int move: moves){
            // 인형 뽑기
            move -= 1;
            for(int i = 0; i < N; i++){
                if(board[i][move] != 0){
                    // 스택의 상단과 일치하는지 확인!
                    if(!stack.isEmpty() && stack.peek() == board[i][move]){
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][move]);
                    }
                    // 인형 빼고 다음 무브로
                    board[i][move] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}