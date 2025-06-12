import java.util.*;
import java.io.*;


public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numArr = new int[10];
        int result = 0;
        
        // 1. char 배열로 변경
        char[] inputArr = br.readLine().toCharArray();
        
        // 2. 순회 하면서 배열 요소 증가시키기
        for(char ch: inputArr){
            numArr[ch - 48] += 1;
        }
        numArr[6] += numArr[9];
        
        // 3. 순회 하면서 최대 값 찾기 (6, 9는 돌아감)
        for(int i = 0; i < 9; i++){
            if(i == 6){
                result = Math.max(result, (numArr[i] + 1)/2);
            } else{
                result = Math.max(result, numArr[i]);
            }
        }
        
        System.out.println(result);
        
    }
}