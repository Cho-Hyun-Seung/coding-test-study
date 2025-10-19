import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[][] paper;
    static int w = 0;
    static int b = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        
        cutPaper(N, 0, 0);
        
        System.out.println(w);
        System.out.println(b);
    }
    
    private static void cutPaper(int size, int x, int y){
        if(!needCut(size, x, y, paper[y][x])){
            if(paper[y][x] == 0) w += 1;
            else b += 1;
            
            return;
        }
        
        int nextSize = size / 2;
        
        cutPaper(nextSize, nextSize + x, y);
        cutPaper(nextSize, x, y + nextSize);
        cutPaper(nextSize, x, y);
        cutPaper(nextSize, x + nextSize, y + nextSize);
    }
    
    private static boolean needCut(int size, int x, int y, int color){
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                // 색이 달라질 경우 자르기
                if(paper[i][j] != color){
                    return true;
                }
            }
        }
        return false;
    }
}