import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static int[] price;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            price = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < N; i++){
                price[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(stockSimulater()).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    private static long stockSimulater(){
        long result = 0L;
        int maxNum = 0;

        for (int i = price.length - 1; i >= 0; i--) {
            if (price[i] >= maxNum) {
                maxNum = price[i];
            } else {
                result += (maxNum - price[i]);
            }
        }
        return result;
    }
}