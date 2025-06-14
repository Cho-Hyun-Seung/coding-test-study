import java.util.*;
import java.io.*;

public class Main{
    private static int N, X;    // 수열의 크기, 타겟 값
    private static int[] arr;    // 수열
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        st =  new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        X = Integer.parseInt(br.readLine());
        
        int left = 0;
        int right = N - 1;
        
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == X){
                result += 1;
                left += 1;
                right -= 1;
            } else if(sum < X) {
                left += 1;
            } else {
                right -= 1;
            }
        }
       
        
        System.out.println(result);
    }
}