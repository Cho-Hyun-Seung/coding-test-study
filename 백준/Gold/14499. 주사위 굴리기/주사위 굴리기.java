import java.util.*;
import java.io.*;

/*
    바닥이 0인 경우? 주사위 아랫면 복사
    바닥이 0이 아닌 경우? 주사위 아랫면에 바닥 복사

*/
public class Main{
    /*
        N, M : 세로, 가로
        X, Y : 주사위를 놓은 곳의 좌표
        K : 명령의 개수
    */
    private static int N, M, X, Y, K;
    private static int[][] map;
    private static int[] dice;
    private static int[] now;
    private static StringBuilder sb;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // 좌 앞 위 뒤 아래 우
        dice = new int[6];
        map = new int[N][M];
        now = new int[]{X, Y};
        
        // 바닥 그려주기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 주사위 이동시키기
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K ; i++) {
            int order = Integer.parseInt(st.nextToken());
            
            int nx = now[0] + dx[order - 1];
            int ny = now[1] + dy[order - 1];
            
            if(!isValid(nx, ny)) continue;
            
            moveDice(order);
            now = new int[]{nx, ny};
            
            if(map[nx][ny] == 0){
                map[nx][ny] = dice[4];
            } else{
                dice[4] = map[nx][ny];
                map[nx][ny] = 0;
            }
            
            sb.append(dice[2]).append("\n");
        }
        
        System.out.println(sb.toString());
        
    }
    
    // 검증
    private static boolean isValid(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M; 
    }
    
    // 주사위 이동
    private static void moveDice(int order){
        int[] temp = dice.clone();
        
        // 동
        if(order == 1){
            dice[2] = temp[0];
            dice[0] = temp[4];
            dice[4] = temp[5];
            dice[5] = temp[2];
        }
        // 서
        if(order == 2){
            dice[2] = temp[5];
            dice[5] = temp[4];
            dice[4] = temp[0];
            dice[0] = temp[2];
        }
        
        // 북
        if(order == 3){
            dice[2] = temp[3];
            dice[3] = temp[4];
            dice[4] = temp[1];
            dice[1] = temp[2];
        }
        
        // 남
        if(order == 4){
            dice[2] = temp[1];
            dice[1] = temp[4];
            dice[4] = temp[3];
            dice[3] = temp[2];
        }
    }
}