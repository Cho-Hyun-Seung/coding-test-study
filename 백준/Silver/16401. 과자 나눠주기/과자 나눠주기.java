import java.util.*;
import java.io.*;

public class Main{
    public static int M, N;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int answer = 0;
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 이분 탐색을 위한 정렬
        Arrays.sort(arr);
        
        int left = 1;
        int right = arr[arr.length - 1];
        
        while(left <= right){
            int mid = left + (right- left) / 2;
            // 조건 만족하는지 확인하기!
            if(breakCookie(mid)){    // 더 길게
                answer = mid;
                left = mid + 1;
            } else {    // 더 짧게
                right = mid -1;
            }
        }
        
        System.out.println(answer);
    }
    
    private static boolean breakCookie(int mid){
        long cookie = 0;
        for(int num: arr){
            cookie += num/mid;
            if(cookie >= M) return true;
        }
        
        return false;
    }
}