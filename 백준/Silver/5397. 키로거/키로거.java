import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int testCase = Integer.parseInt(br.readLine());
        
        while(testCase-- > 0){
            String input = br.readLine();
            char[] charArr = input.toCharArray();
            List<Character> resultList = new LinkedList<>();
            int cur = 0;
            sb = new StringBuilder();
            
            for(char ch: charArr){
                if(ch == '<'){
                    // cur - 1;
                    if(cur > 0){
                        cur -= 1;
                    }
                } else if(ch == '>'){
                    // cur + 1;
                    if(cur < resultList.size()){
                        cur += 1;
                    }
                } else if(ch == '-'){
                    // 글자 지우기
                    if(cur > 0){
                        resultList.remove(cur - 1);
                        cur -= 1;
                    }
                } else{
                    // 글자 입력
                    resultList.add(cur, ch);
                    cur += 1;
                }
                
            }
            for(char ch: resultList){
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }
    }
}