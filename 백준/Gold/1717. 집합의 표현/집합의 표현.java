import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    private static int[] uni;
    
    private static int find(int u){
        if(uni[u] < 0) return u;
        // 상위 노드가 존재하는 경우
        return uni[u] = find(uni[u]);
    }
    
    // 유니온 만들기
    private static boolean makeUni(int u, int v){
        if(u > v){
            int temp = u;
            u = v;
            v = temp;
        }
        
        u = find(u);
        v = find(v);
        
        // 이미 자식 노드일 경우
        if(u == v){
            return false;
        }
        
        uni[v] = u;
        return true;
    }
    
    private static boolean isContain(int u, int v){
        u = find(u);
        v = find(v);
        
        return u == v ? true : false;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        uni = new int[N + 1];
        Arrays.fill(uni, -1);
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int checker = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            if(checker == 1){
                if(isContain(u, v)){
                    sb.append("YES");
                } else{
                    sb.append("NO");
                }
                sb.append("\n");
            } else{
                makeUni(u, v);
            }
        }
        System.out.println(sb.toString());
    }
}