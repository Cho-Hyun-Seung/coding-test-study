import java.io.*;
import java.util.*;
/*
    경우의 수를 모두 구한 뒤에 최솟값 구하기!
    true 팀 false 팀으로 나누기!
*/
public class Main{
    private static int N;
    private static int[][] map;
    private static boolean[] visited;
    private static int minValue = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        visited = new boolean[N];
        
        // 숫자 넣기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
       
        backtracking(0,0);
        
        System.out.println(minValue);
    }
    
    private static void backtracking(int idx, int count){
        // 다 뽑은 경우
        if(count == N/2){
            minValue = Math.min(minValue, getValue());
            return;
        }
        
        if(idx >= N) return;
        
        // 뽑는 경우
        visited[idx] = true;
        backtracking(idx + 1, count + 1);

        // 안뽑는 경우
        visited[idx] = false;
        backtracking(idx + 1, count);
    }
    
    private static int getValue(){
        int S = 0;
        int L = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                int status = map[i][j] + map[j][i];
                // 둘이 한팀 case A
                if(visited[i] && visited[j]){
                    S += status;
                }
                
                // 둘이 한팀 case B
                if(!visited[i] && !visited[j]){
                    L += status;
                }
            }
        }
        return Math.abs(S-L);
    }
}