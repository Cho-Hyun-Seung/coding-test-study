import java.util.*;
import java.io.*;

public class Main{
    private static int K;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        
        K = Integer.parseInt(br.readLine());
        int result = 0;
        
        // 1. 스택 입출력
        for(int i = 0; i < K; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0 && !stack.isEmpty()){
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        
        // 2. 합 하기
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        
        System.out.println(result);
    }
}