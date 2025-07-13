import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    private static Set<Integer> set;
    private static int[] arr;
    private static int[] box;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        set = new HashSet<>();
        
        sb = new StringBuilder();
        
        N =Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        // HashSet에 넣어서 중복 제거해주기
        for(int i = 0; i < N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        arr = new int[set.size()];
        box = new int[M];
        
        // 배열에 hashSet 값 넣어주기
        int idx = 0;
        for(Integer num: set){
            arr[idx] = num;
            idx += 1;
        }
        
        Arrays.sort(arr);
        comb(0, 0);
        
        System.out.println(sb.toString());
    }
    
    
    private static void comb(int depth, int idx){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(box[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = idx; i < arr.length; i++){
            box[depth] = arr[i];
            comb(depth + 1, i);
        }
    }
}