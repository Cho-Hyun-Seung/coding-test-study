import java.util.*;
import java.io.*;

public class Main{
    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int rgMap = 0;   
        int rgbMap = 0;
        
        // map 함수 그려주기
        for(int i = 0; i < N ; i++){
            char[] rgbArr = br.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                if(rgbArr[j] == 'R'){
                    map[i][j] = 0;
                }else if(rgbArr[j] == 'G'){
                    map[i][j] = 1;
                } else{
                    map[i][j] = 2;
                }
            }
        }
       visited = new boolean[N][N];
        // 정상인 경우
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    dfs(i, j, 0, map[i][j]);
                    rgbMap ++;
                }
            }
        }
        visited = new boolean[N][N];
        // 색약의 경우
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    dfs(i, j, 1, map[i][j]);
                    rgMap ++;
                }
            }
        }
        System.out.println(rgbMap + " " + rgMap);
        
    }
    
    private static void dfs(int x, int y, int type, int color){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        
        while(!stack.isEmpty()){
            int[] arr = stack.pop();
            for(int i = 0; i < 4; i++){
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                // 잘 보이는 경우
                if(type == 0){
                    if(nx >= 0 && nx < N && ny >= 0 && ny < N 
                       && !visited[nx][ny] && map[nx][ny] == color){
                        stack.push(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                // 색약 일 경우
                }else{
                    if(color == 2){
                        if(nx >= 0 && nx < N && ny >= 0 && ny < N 
                           && !visited[nx][ny] && map[nx][ny] == 2){
                            stack.push(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }else{
                        if(nx >= 0 && nx < N && ny >= 0 && ny < N 
                           && !visited[nx][ny] && map[nx][ny] < 2){
                            stack.push(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        
    }
    
}