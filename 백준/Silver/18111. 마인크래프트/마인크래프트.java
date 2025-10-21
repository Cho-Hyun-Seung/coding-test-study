import java.util.*;
import java.io.*;
/*
    - 좌표 i, j의 블록 제거후 인벤 추가 (2초)
    - 인벤토리 블록 꺼내 i, j에 추가 (1초)
    
    -> 땅고리그 작업에 걸리는 최소시간과 땅의 높이 출력
*/
public class Main{
    private static int N, M, B;
    private static int[][] ground;
    private static int time = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        ground = new int[N][M];
        int maxHeight = 0;
        int minHeight = Integer.MAX_VALUE;
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                ground[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, ground[i][j]);
                minHeight = Math.min(minHeight, ground[i][j]);
            }
        }
        
        // 가능한 모든 경우의 수 추가
        List<Integer> possibleHeight = new ArrayList<>();
        for(int i = minHeight; i <= maxHeight; i++){
            possibleHeight.add(i);
        }
        
        
        int ansTime = Integer.MAX_VALUE;
        int ansHeight = 0;
        for(int height: possibleHeight){
            int res = grind(B, height);
            if(res == -1) continue;
            if(res <= ansTime){
                ansTime = res;
                ansHeight = height;
            }
        }
        
        System.out.println(ansTime + " " + ansHeight);
    }
    
    
    // 땅 고르기
    private static int grind(int have, int goal){
        int[][] temp = new int[N][M];
        
        for(int i = 0; i < N; i++){
            temp[i] = ground[i].clone();
        }
        
        int time = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                // 목표보다 큰 경우
                if(temp[i][j] > goal){
                    int cnt = temp[i][j] - goal;
                    time += (2 * cnt);
                    have += cnt;
                    temp[i][j] = goal;
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(temp[i][j] < goal){
                    int cnt = goal - temp[i][j];
                    if(have < cnt){
                        return -1;
                    }
                    time += cnt;
                    have -= cnt;
                    temp[i][j] = goal;
                }
            }
        }
        return time;
    }
}