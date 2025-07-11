import java.util.*;
import java.io.*;

public class Main{
    private static int N, result;
    private static int[][] egg;// 내구도, 무게
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        egg = new int[N][2];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            // 내구도
            egg[i][0] = Integer.parseInt(st.nextToken());
            // 무게
            egg[i][1] = Integer.parseInt(st.nextToken());
        }
        
        backT(0);
        System.out.println(result);
    }
    
    static void backT(int idx){
        // 끝까지 다 돈 경우
        if(idx == N){
            int count = 0;
            for(int i = 0; i < N; i++){
                if(egg[i][0] <= 0) count +=1;
            }
            result = Math.max(result, count);
            return;
        }
        // 내구도가 없는 경우
        if(egg[idx][0] <= 0){
            backT(idx + 1);
            return;
        }
        
        boolean hit = false;
        for(int i = 0; i < N; i++){
            if(i != idx && egg[i][0] > 0){
                hit = true;
                
                // 계란 박치기
                egg[idx][0] -= egg[i][1];
                egg[i][0] -= egg[idx][1];
                backT(idx + 1);
                
                // 백트래킹
                egg[idx][0] += egg[i][1];
                egg[i][0] += egg[idx][1];
            }
        }
        if(!hit){
            backT(idx + 1);
        }
    }
}