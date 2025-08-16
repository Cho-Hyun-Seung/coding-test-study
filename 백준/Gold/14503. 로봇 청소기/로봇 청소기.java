import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    private static int[][] room;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0 , -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static Robot robot;
    
    static class Robot{
        int x, y, dir;
        
        Robot(int y, int x, int dir){
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        room = new int[N][M];
        visited = new boolean[N][M];
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        
        robot = new Robot(r, c, dir);
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = cleanRoom();
        
        System.out.println(answer);
    }
    
    private static int cleanRoom(){
        int space = 0;
        
        while(true){
            // 현재 칸이 아직 청소 되지 않은 경우
            if(visited[robot.y][robot.x] == false){
                space += 1;
                visited[robot.y][robot.x] = true;
            }
            
            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            boolean nonCleanExist = false;
            for (int i = 0; i < 4; i++) {
                int turnLeft = (robot.dir + 3) % 4; // 왼쪽으로 회전
                int nx = robot.x + dx[turnLeft];
                int ny = robot.y + dy[turnLeft];

                robot.dir = turnLeft; 

                if (isValid(ny, nx) && room[ny][nx] == 0 && !visited[ny][nx]) {
                    robot.x = nx;
                    robot.y = ny;
                    nonCleanExist = true;
                    break;
                }
            }
            
            if (nonCleanExist) continue;
            
            int goBack = (robot.dir + 2) % 4;
            int nx = robot.x + dx[goBack];
            int ny = robot.y + dy[goBack];

            if (!isValid(ny, nx) || room[ny][nx] == 1) {
                return space;
            }

            // 뒤로 한 칸 이동
            robot.x = nx;
            robot.y = ny;
        }
    }
    
    private static boolean isValid(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}