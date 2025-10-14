import java.util.*;

class Solution {
    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, 1, -1, 0};
    private int N, M;
    private int[][] board;

    public class Node {
        boolean win;
        int count;

        Node(boolean win, int count) {
            this.win = win;
            this.count = count;
        }
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;
        this.board = board;

        Node res = dfs(aloc, bloc);
        return res.count;
    }

    public Node dfs(int[] aloc, int[] bloc) {
        int ax = aloc[0];
        int ay = aloc[1];

        if (board[ax][ay] == 0) return new Node(false, 0);

        int win = Integer.MAX_VALUE;
        int lose = 0;
        boolean canMove = false;

        for (int i = 0; i < 4; i++) {
            int nax = ax + dx[i];
            int nay = ay + dy[i];

            if (!isValid(nax, nay) || board[nax][nay] == 0) continue;

            canMove = true;
            board[ax][ay] = 0;

            Node result = dfs(bloc, new int[]{nax, nay});

            board[ax][ay] = 1;

            if (!result.win) {
                win = Math.min(win, result.count + 1);
            } else {
                lose = Math.max(lose, result.count + 1);
            }
        }

        if (!canMove) return new Node(false, 0);
        if (win != Integer.MAX_VALUE) return new Node(true, win);
        return new Node(false, lose);
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
