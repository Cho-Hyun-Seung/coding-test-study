import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[] arr;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        
        picker(1, 0);
        System.out.println(sb.toString());
    }
    
    public static void picker(int num, int depth){
        if(depth == M){
            for(int i = 0; i< M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = num; i <= N; i++){
            arr[depth] = i;
            picker(arr[depth], depth + 1);
        }
    }
}