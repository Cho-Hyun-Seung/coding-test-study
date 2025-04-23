import java.util.*;
import java.io.*;

public class Main{
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        int maxNum = 0;
        int maxSafeArea = 1;
        
        // 지도 그리기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                maxNum = Math.max(maxNum, area[i][j]);
            }
        }
        
        for(int k = 1; k <= maxNum; k++){
            visited = new boolean[N][N];
            int safeArea = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j] && area[i][j] > k){
                        dfs(i, j, k);
                        safeArea++;
                    }
                }
            }
            maxSafeArea = Math.max(maxSafeArea, safeArea);
        }
        
        System.out.println(maxSafeArea);
        
    }
    
    static void dfs(int x, int y, int v){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        
        while(!stack.isEmpty()){
            int[] arr = stack.pop();
            for(int i = 0 ; i < 4; i++){
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                
                if(nx >= 0 && nx < area.length 
                   && ny >= 0 && ny < area[0].length 
                   && !visited[nx][ny] && area[nx][ny] > v){
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
    }
    
    
    static boolean checker(int x, int y, int v){
        return !visited[x][y] && area[x][y] > v;
    }
}