import java.util.*;
import java.io.*;

public class Main{
    private static int M, N;
    private static int[][] box;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0 ,0, 1, -1};
    
    public static class Dots{
        int x, y, day;
        
        public Dots(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day =day;
        }
    }
    
    public static int bfs(){
        Queue<Dots> que = new LinkedList<>();
        int result = 0;
        
        // 초기 토마토 입력
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] == 1){
                    que.offer(new Dots(j, i, 0));
                }
            }
        }
        
        while(!que.isEmpty()){
            Dots cur = que.poll();
            result = Math.max(0, cur.day);
            
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(isValid(nx, ny) && box[ny][nx] == 0){
                    box[ny][nx] = 1;
                    que.offer(new Dots(nx, ny, cur.day + 1));
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] == 0) return -1;
            }
        }
        return result;
    }
    
    public static boolean isValid(int x, int y){
        return x >= 0 && x < M && y >=0 && y< N;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(bfs());
    }
}