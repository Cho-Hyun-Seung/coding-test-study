import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    private static int[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(binarySearch());
    }
    
    private static long binarySearch(){
        long minTree = 0;
        long left = 0;
        long right = Arrays.stream(tree).max().orElse(0);
        
        while(left <= right){
            long mid = (left + right) / 2;
            long result = 0;
            for(int height: tree){
                // 0 이하는 안잘림
                if(height > mid){
                    result += height - mid;
                }
            }
            
            if(result >= M){
                minTree = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        
        return minTree;
    }
}