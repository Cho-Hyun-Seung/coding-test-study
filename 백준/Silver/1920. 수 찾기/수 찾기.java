import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        HashSet<Integer> set = new HashSet<>();
        
        while(st.hasMoreTokens()){
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        while(st.hasMoreTokens()) {
            if(set.contains(Integer.parseInt(st.nextToken()))){
                sb.append(1);
            }else{
                sb.append(0);
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
        
    }
}