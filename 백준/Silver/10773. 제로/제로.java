import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int testCase = Integer.parseInt(br.readLine());
        int sum = 0;
        
        while(testCase-- > 0){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) stack.pop();
            else stack.push(num);
        }
        
        while(!stack.isEmpty()) sum += stack.pop();
        
        System.out.println(sum);
    }
}