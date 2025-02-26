import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] arr = new double[length];
        double maxNum = 0.0;
        double sum = 0.0;
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = Double.parseDouble(st.nextToken());
            maxNum = Math.max(maxNum, arr[i]);
        }
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i]/maxNum*100;
            sum += arr[i];
        }
        
        System.out.println(sum/length);
        
    }
}