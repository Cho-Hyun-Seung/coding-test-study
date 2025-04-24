import java.util.*;
import java.io.*;

public class Main{
    static int[][] paper;
    static boolean[][] visited;
    static int[] dx = {-1, 1 ,0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int M;
    static int N;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        paper = new int[M][N];
        visited = new boolean[M][N];
        List<Integer> sizeList = new ArrayList<>();
        
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int lx= Integer.parseInt(st.nextToken());
            int ly= Integer.parseInt(st.nextToken()); 
            int rx= Integer.parseInt(st.nextToken());
            int ry= Integer.parseInt(st.nextToken());
            for(int x = lx; x < rx; x++){
                for(int y = ly; y < ry; y++){
                    paper[y][x] = 1;
                }
            }
        }
        
        for(int i = 0 ; i < M; i ++){
            for(int j = 0; j < N; j++){
                if(checker(i, j)){
                    int size = dfs(i, j);
                    sizeList.add(size);
                }
            }
        }
        Collections.sort(sizeList);
        sb.append(sizeList.size()).append("\n");
        for(int num : sizeList){
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString());
    }
    
    static int dfs(int y, int x){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{y, x});
        visited[y][x] = true;
        int num = 0;
        
        while(!stack.isEmpty()){
            int[] arr = stack.pop();
            num +=1;
            
            for(int i = 0; i < 4; i++){
                int ny = arr[0] + dy[i];
                int nx = arr[1] + dx[i];
                if(checker(ny, nx)){
                    visited[ny][nx] = true;
                    stack.push(new int[]{ny, nx});
                }
            }
        }
        
        return num;
    }
    
    
    static boolean checker(int y, int x){
        return y >= 0 && y < M && x >= 0 && x < N 
            && !visited[y][x] && paper[y][x] == 0;
    }
    
}