import java.util.*;
import java.io.*;

public class Main{
    private static int[][] wheels;
    private static int[] direction;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;

        wheels = new int[4][8];

        // 배열에 넣어 주기
        for(int i = 0; i < 4; i++){
            String edges = br.readLine();
            for(int j = 0; j < 8; j++){
                wheels[i][j] = edges.charAt(j) - '0';
            }
        }

        // 케이스 수
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0){
            direction = new int[4];
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            direction[idx] = dir;

            // 왼쪽 요소 돌리기
            for (int i = idx - 1; i >= 0; i--) {
                if (wheels[i][2] != wheels[i + 1][6]) {
                    direction[i] = -direction[i + 1];
                } else {
                    break;
                }
            }

            // 오른쪽 요소 돌리기
            for (int i = idx + 1; i < 4; i++) {
                if (wheels[i - 1][2] != wheels[i][6]) {
                    direction[i] = -direction[i - 1];
                } else {
                    break;
                }
            }

            // 돌리기 실행
            for (int i = 0; i < 4; i++) {
                if (direction[i] == 1) {
                    turnCW(i);
                } else if (direction[i] == -1) {
                    turnCCW(i);
                }
            }
        }

        // 값 더하기
        for (int i = 0; i < 4; i++) {
            if (wheels[i][0] == 1) {
                result += (1 << i);
            }
        }
        System.out.println(result);
    }

    /* 시계 방향으로 돌리기 */
    private static void turnCW(int idx) {
        int[] temp = wheels[idx].clone();
        for (int i = 0; i < 8; i++) {
            wheels[idx][i] = temp[(i + 7) % 8];
        }
    }

    /* 반시계 방향으로 돌리기 */
    private static void turnCCW(int idx) {
        int[] temp = wheels[idx].clone();
        for (int i = 0; i < 8; i++) {
            wheels[idx][i] = temp[(i + 1) % 8];
        }
    }
}
