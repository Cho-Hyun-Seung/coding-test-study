import java.util.*;
import java.io.*;

public class Main{
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int result = 0;
            // 종료 조건
            if(w == 0 && h == 0){
                break;
            }
            
            map = new int[h][w];
            visited = new boolean[h][w];
            
            // 지도 그려주기
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 지도 순회하기
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        dfs(i, j);
                        result ++;
                    }
                }
            }
            sb.append(result).append("\n");
        }
       
        System.out.println(sb.toString());
    }
    
    static void dfs(int h, int w){
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{h, w});
        visited[h][w] = true;
        
        while(!stack.isEmpty()){
            int[] arr = stack.pop();
            for(int i = 0; i < 8; i++){
                int dh = arr[0] + dx[i];
                int dw = arr[1] + dy[i];
                if(dh >= 0 && dh < map.length 
                   && dw >= 0 && dw < map[0].length
                  && !visited[dh][dw] && map[dh][dw] == 1){
                    stack.add(new int[]{dh, dw});
                    visited[dh][dw] = true;
                }
            }
        }
    }
}