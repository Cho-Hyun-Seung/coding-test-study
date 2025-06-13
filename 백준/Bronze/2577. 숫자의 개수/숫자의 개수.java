import java.util.*;
import java.io.*;

public class Main{
    private static int A,B,C;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[10];
        
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        
        int data = A*B*C;
        
        String str = data + "";
        
        for(char ch: str.toCharArray()){
            arr[ch-48] +=1;
        }
        
        for(int num: arr){
            sb.append(num).append("\n");
        }
        System.out.println(sb.toString());
    }
}