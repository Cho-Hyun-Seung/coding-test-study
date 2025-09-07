import java.util.*;
import java.io.*;

public class Main{
    private static List<Integer> numList;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        while(T -- > 0){
            numList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long sumOfGCD = 0;
            
            for(int i = 0; i < N; i++){
                numList.add(Integer.parseInt(st.nextToken()));
            }
            
            for(int i = 0; i < numList.size(); i++){
                for(int j = i + 1; j < numList.size(); j++){
                    sumOfGCD += (long)gcd(numList.get(i), numList.get(j));
                }
            }
            sb.append(sumOfGCD).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    private static int gcd(int a, int b) {
        while (b != 0) {
            int rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }
}