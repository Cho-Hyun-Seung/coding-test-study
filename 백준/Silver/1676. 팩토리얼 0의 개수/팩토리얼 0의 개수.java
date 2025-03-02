import java.util.*;
import java.io.*;

public class Main{
    /*
    private static int factorial(int num){
        if(num == 0){
            return 1;
        }
        return num * factorial(num - 1);
    }
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result = 0;
        
        for(int i = 1; i <= num ; i++){
            int temp = i;
            while(temp % 5 == 0){
                temp /= 5;
                result +=1;
            }
        }
        
        System.out.println(result);
        
        
        
        /*
        String factorialNum = "" + factorial(num);
        int result = 0;
        // 0을 포함하지 않은 경우
        if(factorialNum.contains("0")) {
            for(int i = factorialNum.length() - 1; i >= 0; i--){
                char c = factorialNum.charAt(i);
                if(c != '0'){
                    break;
                }
                result += 1;
            }
        }
        System.out.println(result);
        */
    }
}