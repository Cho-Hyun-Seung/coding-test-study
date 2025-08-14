import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static int[] numArr;
    private static int[] operator; // [+, -, *, /]
    private static long maxValue = Long.MIN_VALUE;
    private static long minValue = Long.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        operator = new int[4];
        
        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 연산자 개수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        
        backtracking(1, numArr[0]);
        
        sb.append(maxValue).append("\n").append(minValue);
        System.out.println(sb.toString());
    }
    
    private static void backtracking(int idx, long sum){
        if (idx == N){
            maxValue = Math.max(maxValue, sum);
            minValue = Math.min(minValue, sum);
            return;
        }
        
        for (int i = 0; i < 4; i++){
            if (operator[i] == 0) continue;
            operator[i]--;
            long cur = operate(idx, sum, i);
            backtracking(idx + 1, cur);
            operator[i]++;
        }
    }

    private static long operate(int idx, long sum, int operIdx){
        int b = numArr[idx];
        switch (operIdx){
            case 0: return sum + b;
            case 1: return sum - b;
            case 2: return sum * b;
            case 3:
                if ((sum >= 0 && b > 0) || (sum <= 0 && b < 0)) {
                    return sum / b;
                } else {
                    return -(Math.abs(sum) / Math.abs(b));
                }
        }
        return -1;
    }
}
