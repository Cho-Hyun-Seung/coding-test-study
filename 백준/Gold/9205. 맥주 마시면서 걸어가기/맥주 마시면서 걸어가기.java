import java.util.*;
import java.io.*;

public class Main{
    private static int[] HOME, FEST;
    private static int[][] CONV;
    private static boolean[] visited;
    private static StringTokenizer st;
    private static BufferedReader br;
    
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int testcase = Integer.parseInt(br.readLine());
        
        while(testcase-- > 0){
            initData();
            System.out.println(bfs() ? "happy" : "sad");
        }
    }
    
    private static boolean bfs(){
        Queue<int[]> que = new LinkedList<>();
        que.offer(HOME);
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            // 페스티벌에 도착이 가능한 경우
            if(isValid(curX, curY, FEST[0], FEST[1])){
                return true;
            }
            
            for(int i = 0; i < CONV.length; i++){
                int convX = CONV[i][0];
                int convY = CONV[i][1];
                if(isValid(curX, curY, convX, convY) && !visited[i]){
                    que.offer(new int[]{convX, convY});
                    visited[i] = true;
                }
            }
        }
        return false;
    }
    
    private static boolean isValid(int curX, int curY, int targetX, int targetY){
        return Math.abs(curX - targetX) + Math.abs(curY - targetY) <= 1000;
    }
    
    public static void initData() throws IOException {
        int convCount = Integer.parseInt(br.readLine());
        HOME = new int[2];
        FEST = new int[2];
        CONV = new int[convCount][2];
        visited = new boolean[convCount];
        insertCoord(HOME);
        for(int[] conv: CONV){
            insertCoord(conv);
        }
        insertCoord(FEST);
    }
    
    private static void insertCoord(int[] arr) throws IOException {
        st = new StringTokenizer(br.readLine());
        int coordX = Integer.parseInt(st.nextToken());
        int coordY = Integer.parseInt(st.nextToken());
        arr[0] = coordX;
        arr[1] = coordY;
    }
}
