import java.util.*;
import java.io.*;

public class Main{
    static int[][] paper;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        paper = new int[N][M];
        visited = new boolean[N][M];
        int maxLength = 0;
        int paperCount = 0;
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && paper[i][j] == 1){
                    int length = dfs(i, j);
                    maxLength = Math.max(maxLength, length);
                    paperCount++;
                }
            }
        }
        
        sb.append(paperCount).append("\n")
            .append(maxLength).append("\n");
        
        System.out.println(sb.toString());
    }
    static int dfs(int x, int y){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;
        
        while(!stack.isEmpty()){
            int[] arr = stack.pop();
            for(int i = 0; i < 4; i++){
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                if(nx >=0 && nx < paper.length 
                   && ny >=0 && ny <paper[0].length
                  && !visited[nx][ny] && paper[nx][ny] == 1){
                    visited[nx][ny] = true;
                    count++;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
        return count;
    }
}