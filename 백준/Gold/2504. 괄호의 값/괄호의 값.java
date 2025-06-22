import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int temp = 1;

        for(int i = 0; i < charArr.length; i++){
            char ch = charArr[i];
            
            // 괄호가 들어온 경우
            if(ch == '('){
                stack.push(ch);
                temp *= 2;
            // 대괄호가 들어온 경우
            } else if(ch == '['){
                stack.push(ch);
                temp *= 3;
            // 괄호가 닫힌 경우
            } else if(ch == ')'){
                // 에러 발생 가능 상황
                if(stack.isEmpty() || stack.peek() != '('){
                    System.out.println(0);
                    return;
                }
                // 바로 닫힌 경우
                if(charArr[i-1] == '(') {
                    result += temp;
                }
                stack.pop();
                temp /= 2;
            // 대괄호가 닫힌 경우
            } else if(ch == ']'){
                // 에러 발생 가능 상황
                if(stack.isEmpty() || stack.peek() != '['){
                    System.out.println(0);
                    return;
                }
                // 닫힌 경우
                if(charArr[i-1] == '[') {
                    result += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        if(!stack.isEmpty()){
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
