import java.util.*;
import java.io.*;

public class Main{
    private static boolean isBalance(String string){
        Stack<String> stack = new Stack<>();
        List<String> openList = Arrays.asList("(", "{", "[");
        List<String> closeList = Arrays.asList(")", "}", "]");
        String[] arr = string.split("");
        for(String str : arr){
            if(openList.contains(str)){
                stack.push(str);
            }
            if(closeList.contains(str)){
                // 스택이 빈 경우
                if(stack.isEmpty()){
                    return false;
                }
                // 서로 다른 경우
                String stackTop = stack.pop();
                if(openList.indexOf(stackTop) != closeList.indexOf(str)){
                    return false;
                }
            }
        }
        // 스택이 비지 않은 경우
        return stack.isEmpty() ? true : false;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String line = br.readLine();

            if(line.equals(".")) {
                break;
            }

            if(isBalance(line)){
                sb.append("yes").append("\n");
            }else{
                sb.append("no").append("\n");
            }

        }
        System.out.println(sb);
    }
}