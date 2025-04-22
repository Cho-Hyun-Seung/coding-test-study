import java.util.*;
import java.io.*;

public class Main{
    static int[][] board = new int[5][5];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static HashSet<Integer> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 지도 그려주기
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                dfs(i,j);
            }
        }
        
        System.out.println(set.size());
    }
    
    private static void dfs(int a, int b){
        Stack<int[]> stack = new Stack<>();
        // x, y, sum, depth
        stack.add(new int[]{a, b, 0, 0});
        
        while(!stack.isEmpty()){
            int[] dot = stack.pop();
            int x = dot[0];
            int y = dot[1];
            int sum = dot[2];
            int depth = dot[3];
            if(depth == 6){
                set.add(sum);
                continue;
            }
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < 5 && ny >=0 && ny <5){
                    int tempSum = sum + board[nx][ny]*(int)Math.pow(10, depth);
                    stack.add(new int[]{nx, ny, tempSum, depth + 1});
                }
            }
        }
         
    }
}