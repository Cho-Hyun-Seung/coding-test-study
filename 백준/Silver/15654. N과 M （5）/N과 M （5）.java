import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    private static int[] arr;
    private static boolean[] visited;
    private static int[] box;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        box = new int[M];
        
        st = new StringTokenizer(br.readLine());
        // 배열에 값 넣기
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        picker(0);
        
        System.out.println(sb.toString());
    }
    
    public static void picker(int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(box[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                box[depth] = arr[i];
                visited[i] = true;
                picker(depth + 1);
                visited[i] = false;
            }
        }
    }
}