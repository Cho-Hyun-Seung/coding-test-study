import java.util.*;
import java.io.*;

public class Main{
    static char[][] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // 가로 길이 -> N*2 - 1
        int w = N * 2 -1;
        int h = N;
        
        arr = new char[h][w];
        
        for(int i = 0; i < h; i++){
            Arrays.fill(arr[i], ' ');
        }
        
        // 맨 위가 시작?
        star(w/2, 0, N);
        
        for(int i = 0; i < h; i ++){
            for(int j = 0; j < w; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    
    private static void star(int x, int y, int N){
        // 3 * 5 별 그려주기
        if(N == 3){
            arr[y][x] = '*';
            arr[y+1][x-1] = '*';
            arr[y+1][x+1] = '*';
            for(int i = 0; i < 5; i++){
                arr[y+2][x - 2 + i] = '*';
            }
            return;
        }
        
        int size = N/2;
        // 위 삼각
        star(x,y, size);
        // 좌 삼각
        star(x - size, y + size, size);
        // 우 삼각
        star(x + size, y + size, size);
    }
}