import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    private static int[] arr;
    private static int[] box;
    private static StringBuilder sb;
    private static LinkedHashSet<List<Integer>> set = new LinkedHashSet<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        
        for(List<Integer> list: set){
            for(int num: list){
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
                
        System.out.println(sb.toString());
    }
    
    private static void picker(int depth, int idx){
        if(depth == M){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < M; i++){
                list.add(box[i]);
            }
            set.add(list);
            return;
        }
        
        for(int i = idx; i < N; i++){
            box[depth] = arr[i];
            picker(depth+1, i + 1);
        }
    }
}