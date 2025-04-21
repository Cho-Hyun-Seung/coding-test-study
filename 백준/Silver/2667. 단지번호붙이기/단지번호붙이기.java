import java.util.*;
import java.io.*;

public class Main{
    static int[][] map;
    static int N = 0;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        int danji = 0;
        List<Integer> list = new ArrayList<>();
        // 지도 그려주기
        for(int i = 0; i < N; i++) {
            String col = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = col.charAt(j) - '0';
            }
        }
        // 지도 돌기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]&& map[i][j] == 1){
                    visited[i][j] = true;
                    map[i][j] = ++danji;
                    int count = dfs(i,j, danji);
                    list.add(count);
                }
            }
        }
        
        sb.append(danji).append("\n");
        Collections.sort(list);
        for(int num: list){
            sb.append(num).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    private static int dfs(int x, int y, int danji){
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{x, y});
        int count = 1;
        
        
        while(!stack.isEmpty()){
            int[] dot = stack.pop();
            for(int i = 0; i < 4; i++){
                int nx = dot[0] + dx[i];
                int ny = dot[1] + dy[i];
                if(nx >=0 && nx < N && ny >= 0 && ny < N 
                   && !visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    count++;
                    stack.add(new int[]{nx, ny});
                }
            }
        }
        return count;
        
    }
}