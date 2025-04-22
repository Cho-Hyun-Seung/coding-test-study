import java.util.*;
import java.io.*;

public class Main{
    static String [][] campus;
    static boolean [][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int M;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new String[N][M];
        visited = new boolean[N][M];
        
        int stdX = 0;
        int stdY = 0;
        
        // 지도 그리기
        for(int i = 0; i <N; i++){
            String[] arr = br.readLine().split("");
            for(int j = 0; j < M; j++){
                campus[i][j] = arr[j];
                // 도연이 위치 저장
                if(arr[j].equals("I")){
                    stdX = i;
                    stdY = j;
                }
            }
        }
        
        int result = dfs(stdX, stdY);
        
        if(result == 0){
            System.out.println("TT");
        }else{
            System.out.println(result);
        }
        
    }
    
    static int dfs(int x, int y){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        int result = 0;
        
        while(!stack.isEmpty()){
            int[] dot = stack.pop();
            for(int i = 0; i < 4; i++){
                int nx = dot[0] + dx[i];
                int ny = dot[1] + dy[i];
                if(nx >=0 && nx < N && ny >= 0 && ny < M 
                   && !visited[nx][ny] && !campus[nx][ny].equals("X")){
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                    if(campus[nx][ny].equals("P")){
                        result +=1;
                    }
                }
            }
        }
        return result;
    }
}