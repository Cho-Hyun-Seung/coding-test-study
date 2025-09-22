import java.util.*;
import java.io.*;

public class Main{
    private static int N, d, k, c;
    private static List<Integer> rotate;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rotate = new ArrayList<>();
        
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++){
            rotate.add(Integer.parseInt(br.readLine()));
        }
        
        int[] count = new int[d + 1];
        int curKind = 0;;
        int maxKind = 0;
        
        for(int i = 0; i < k; i++){
            // 종류 추가
            if(count[rotate.get(i)] == 0) curKind +=1;
            count[rotate.get(i)] += 1;
        }
        
        maxKind = (count[c] == 0 ? curKind + 1 : curKind);
        
        for(int i = 1; i < N; i++){
            int left = rotate.get(i - 1);
            int right = rotate.get((i + k - 1) % N);
            
            // 좌 제거 우 추가
            count[left] -= 1;
            // 종류 추가 조건
            if(count[left] == 0) curKind -=1;
            
            count[right] += 1;
            if(count[right] == 1) curKind +=1;
            
            // 쿠폰 조건
            maxKind = Math.max(maxKind, count[c] == 0 ? curKind + 1: curKind);
        }
        
        System.out.println(maxKind);
    }
}