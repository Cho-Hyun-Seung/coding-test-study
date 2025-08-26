import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static long[][] dots;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long result = 0L;
        
        N = Integer.parseInt(br.readLine());
        dots = new long[N][2];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            dots[i][0] = Long.parseLong(st.nextToken());
            dots[i][1] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(dots, (a,b) -> {
            int compareX = Long.compare(a[0], b[0]);
            if(compareX == 0) return Long.compare(a[1], b[1]);
            return compareX;
        });
        
        long[] prev = dots[0];
        for(long[] num: dots){
            // x가 이전 y보다 큰 경우
            if(num[0] > prev[1]){
                result += prev[1] - prev[0];
                prev = num;
            // x가 이전 y보다 작은 경우
            } else {
                prev[1] = Math.max(prev[1], num[1]);
            }
        }
        result += prev[1] - prev[0];
        System.out.println(result);
    }
}