import java.util.*;
import java.io.*;

public class Main{
    private static int N, K;
    private static boolean[] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1];
        
        System.out.println(findNum());
    }
    
    private static int findNum(){
        int count = 0;
        int idx = 2;
        int result = 0;
        
        while(count < K){
            int targetNum = 0;
            for(int i = idx; i <= N; i++){
                // 이번에 지울 수 선택
                if(!arr[i]){
                    targetNum = i;
                    break;
                }
            }
            
            for(int i = targetNum; i <= N; i++){
                if(!arr[i] && i%targetNum == 0){
                    arr[i] = true;
                    count +=1;
                    if(count == K){
                        return i;
                    }
                }
            }
        }
        
        return -1;
    }
}