import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int result = 0;
        
        // 문자 배열에 넣기
        for(int i = 0; i < N; i++){
            String word = br.readLine();
            if(isGood(word)){
                result +=1;
            }
        }
        
        System.out.println(result);
        
    }
    
    private static boolean isGood(String word){
        Stack<Character> stack = new Stack<>();
        
        for(char c: word.toCharArray()){
            // 스택이 빈 경우 push
            if(stack.isEmpty()){
                stack.push(c);
            } else{
                // 스택에 맨 윗 값이 c와 일치하는 경우
                if(stack.peek() == c){
                    stack.pop();
                // 아닌경우
                } else {
                    stack.push(c);
                }
            }
        }
        
        return stack.isEmpty() ? true : false;
    }
}