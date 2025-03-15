import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String, String> hashmap = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            hashmap.put(st.nextToken(), st.nextToken());
        }
        
        for(int i = 0; i < m ; i++){
            sb.append(hashmap.get(br.readLine())).append("\n");
        }
        
        System.out.println(sb);
    }
}