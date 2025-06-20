import java.util.*;
import java.io.*;


public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        
        int result = 0;
        int pipe = 0;
        
        char[] charArr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for(char ch: charArr){
            // 스택이 빈 경우
            if(stack.isEmpty()){
                stack.push(ch);
            } else {
               if(stack.peek() == '(' && ch =='('){
                    pipe +=1;
                } else if(stack.peek() == '(' && ch == ')'){
                    stack.pop();
                    result += pipe;
                } else if(stack.peek() == ')' && ch == ')'){
                    stack.pop();
                    pipe -=1;
                    result += 1;
                }
                stack.push(ch);
            }
        }
        System.out.println(result);
    }
}