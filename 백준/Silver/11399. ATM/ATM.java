import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static int[] atm;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        atm = new int[N];
        for(int i = 0; i < N; i++){
            atm[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(atm);
        int time = 0;
        int result = 0;
        for(int i = 0; i < N; i++){
            result = result + atm[i];
            time += result;
        }
        
        System.out.println(time);
    }
}