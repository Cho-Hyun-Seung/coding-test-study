import java.util.*;
import java.io.*;

public class Main {
    private static int[][] paper;
    private static int N;
    private static int minus = 0;
    private static int zero = 0;
    private static int plus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutting(0, 0, N);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    // 종이 자르기
    private static void cutting(int row, int col, int size) {
        // 1. 검증부터 하기
        if (isValidPaper(row, col, size)) {
            int num = paper[row][col];
            if (num == -1) minus++;
            else if (num == 0) zero++;
            else plus++;
            return;
        }

        // 2. 검증 안되면 자르기
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cutting(row + i * newSize, col + j * newSize, newSize);
            }
        }
    }

    // 종이 검증
    private static boolean isValidPaper(int row, int col, int size) {
        int num = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != num) return false;
            }
        }
        return true;
    }
}
