import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static int[][] triangle;
    private static int[][] sum;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;
        
        N = Integer.parseInt(br.readLine());
        sum = new int[N][N];
        triangle = new int[N][N];
        
        // 내부 채워주기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        sum[0][0] = triangle[0][0];
        
        dp();
        
        for(int i = 0; i < N; i++){
            result = Math.max(sum[N-1][i], result);
        }
        
        System.out.println(result);
    }
    
    private static void dp(){
        for(int i = 1; i < N; i++){
            for(int j = 0; j <= i; j++){
                // 좌측
                if(j == 0){
                    sum[i][j] = sum[i - 1][j] + triangle[i][j];
                }
                // 우측
                else if(j == i){
                    sum[i][j] = sum[i-1][j-1] + triangle[i][j];
                } 
                // 중앙
                else {
                    sum[i][j] = Math.max(sum[i-1][j-1], sum[i-1][j]) + triangle[i][j];
                }
            }
        }
    }
}