import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int length = Integer.parseInt(br.readLine());
        
        long[] roads = new long[length - 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < roads.length; i++){
            roads[i] = Long.parseLong(st.nextToken());
        }
        
        int[] oils = new int[length];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < oils.length; i++){
            oils[i] = Integer.parseInt(st.nextToken());
        }
        
        long nowOilCost = oils[0];    // 현재 비용
        long cost = 0;
        
        for(int i = 0; i < roads.length; i++){
            
            if(oils[i] < nowOilCost){
                nowOilCost = oils[i];
            }
            cost += roads[i] * nowOilCost;
        }
        System.out.println(cost);
    }
}