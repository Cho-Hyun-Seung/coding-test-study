import java.util.*;
import java.io.*;


public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // 탑 정보 넣기 [idx] = 높이
        int[] tower = new int[N];
        
        // 결과 배열
        int[] result = new int[N];
        
        Stack<Integer> stack = new Stack<>();
        
        // 배열에 순서대로 넣어주기
        for(int i = 0; i < N; i++){
            tower[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = N-1; i >=0; i--){
            
            // 스택에 값이 있고, 스택의 상단이 현재보다 작으면 push
            while(!stack.isEmpty() && tower[stack.peek()] <= tower[i]){
                int idx = stack.pop();
                result[idx] = i + 1;
            }
            stack.push(i);
        }
        
        for(int i = 0; i < N; i++){
            sb.append(result[i]).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}