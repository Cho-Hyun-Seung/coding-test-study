import java.io.*;
import java.util.*;

public class Main{
    private static int gcd(int a, int b){
        if(a % b == 0){
            return b;
        }
        
        return gcd(b, a%b);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int gcdNum = gcd(Math.max(a,b), Math.min(a,b));
        sb.append(gcdNum + "\n");
        int gcmNum = a*b/gcdNum;
        sb.append(gcmNum);
        
        System.out.println(sb.toString());
    }
}