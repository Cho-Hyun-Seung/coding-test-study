import java.util.*;
import java.io.*;

public class Main{
    private static int U, K;
    private static int[] uni;
    
    static int find(int u){
        if(uni[u] < 0) return u;
        return uni[u] = find(uni[u]);
    }
    
    static boolean makeUni(int u, int v){
        u = find(u);
        v = find(v);
        
        if(u == v){
            return false;
        }
        
        uni[v] = u;
        return true;
    }
    
    static boolean isFriend(int u , int v){
        u = find(u);
        v = find(v);
        
        return u == v ? true : false; 
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= T; i++){
            // 초기 입력
            U = Integer.parseInt(br.readLine());
            K = Integer.parseInt(br.readLine());
            uni = new int[U];
            Arrays.fill(uni, -1);
            
            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                makeUni(u, v);
            }
            
            int scenarioCount = Integer.parseInt(br.readLine());
            sb.append("Scenario ").append(i).append(":").append("\n");
            for(int j = 0 ; j < scenarioCount; j++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if(isFriend(u, v)){
                    sb.append("1");
                } else{
                    sb.append("0");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}