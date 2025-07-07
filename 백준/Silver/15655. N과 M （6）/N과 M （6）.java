import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    private static int[] arr;
    private static int[] box;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        box = new int[M];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        picker(0,0);
        
        System.out.println(sb.toString());
    }
    
    public static void picker(int depth, int idx){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(box[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = idx; i < N; i++){
            box[depth] = arr[i];
            picker(depth +1, i + 1);
        }
    }
}