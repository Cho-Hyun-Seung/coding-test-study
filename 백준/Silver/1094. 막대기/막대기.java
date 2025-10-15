import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
        int X = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i =0; i < 7; i++){
            if((X & (1 << i)) > 0) answer += 1;
        }
        
        System.out.println(answer);
    }
}