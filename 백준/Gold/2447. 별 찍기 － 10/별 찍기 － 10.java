import java.util.*;
import java.io.*;

// 3 제곱 단위로 박스가 커짐
// 3, 9, 27
// (1,1) (4,1) (7,1) ~~ (3)씩 증가
// (1,4), (3~5, 3~5) 
public class Main{
    private static char[][] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        
        star(0, 0, N, false);
        
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
    
    // 분할 정복! 최소단위 까지 쪼개기 최소단위? (1 x 1)
    // https://st-lab.tistory.com/95
    private static void star(int x, int y, int B, boolean blank){
        // 공백인 경우
        if(blank){
            for(int i = x; i < x + B; i++){
                for(int j = y; j < y + B; j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        
        
        // 쪼개기 최소 단위
        if(B == 1){
            arr[x][y] = '*';
            return;
        }
        
        int size = B/3;
        // x + N: x 번 ~ x+N이 한 블럭!
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int nx = x + i*size;
                int ny = y + j*size;
                // 공백인 경우
                if(i == 1 && j == 1){
                    star(nx, ny, size, true);
                } else {
                    star(nx, ny, size, false);
                }
            }
        }
        
    }
}