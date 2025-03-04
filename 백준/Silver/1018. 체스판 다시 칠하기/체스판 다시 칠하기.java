import java.io.*;
import java.util.*;

public class Main {
    public static char[][] board;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                reDraw(i, j);
            }
        }
        System.out.println(min);
    }

    public static void reDraw(int startN, int startM) {
        int count = 0; 
        char firstColor = board[startN][startM]; 

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[startN + i][startM + j] != firstColor) {
                    count++;
                }
                firstColor = (firstColor == 'W') ? 'B' : 'W'; 
            }
            firstColor = (firstColor == 'W') ? 'B' : 'W'; 
        }

        count = Math.min(count, 64 - count);

        min = Math.min(min, count);
    }
}
