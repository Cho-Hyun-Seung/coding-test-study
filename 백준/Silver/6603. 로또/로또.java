import java.util.*;
import java.io.*;

public class Main{
    private static int arr[];
    private static int box[];
    private static int N;
    // 로또 6개 중 고르기
    private static int M = 6;
    private static StringTokenizer st;
    private static  BufferedReader br;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException{
        sb = new StringBuilder();
        br = new BufferedReader(new InputStreamReader(System.in));
        
        lottery();
        
        System.out.println(sb.toString());
    }
    
    private static void lottery() throws IOException{
        st = new StringTokenizer(br.readLine());
        
        // 1. 첫번 째 수가 앞으로 몇 개의 수가 나올지 결정함!
        N = Integer.parseInt(st.nextToken());
        
        // 2. N이 0이면 종료
        if(N == 0){
            return;
        }
        
        // 3. 배열에 값 넣어주기
        arr = new int[N];
        box = new int[M];
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 사전순으로 정렬하기 위함
        Arrays.sort(arr);
        
        
        // 4. 재귀를 통해 돌아주기
        comb(0, 0);
        sb.append("\n");
        // 5. lottery 다시 돌기
        lottery();
        
    }
    
    private static void comb(int depth, int idx) throws IOException{
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(box[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = idx; i < N; i++){
            box[depth] = arr[i];
            comb(depth +1, i + 1);
        }
    }
}