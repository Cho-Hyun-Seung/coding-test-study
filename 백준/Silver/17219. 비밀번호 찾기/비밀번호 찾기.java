import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        HashMap<String, String> map = new HashMap<>();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String siteURL = st.nextToken();
            String password = st.nextToken();
            map.put(siteURL, password);
        }
        
        
        for(int i = 0; i < M; i++){
            sb.append(map.get(br.readLine())).append("\n");
        }
        
        System.out.println(sb);
    }
}