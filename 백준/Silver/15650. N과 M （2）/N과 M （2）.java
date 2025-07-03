import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    private static boolean[] visited;
    private static int[] set;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new int[M];
        picker(1, 0);
        
        System.out.println(sb.toString());
    }
    
    public static void picker(int num, int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(set[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = num; i <= N; i++){
            set[depth] = i;
            picker(i + 1, depth+1);
        }
    }
}