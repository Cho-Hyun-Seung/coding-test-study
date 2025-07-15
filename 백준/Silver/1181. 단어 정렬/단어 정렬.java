import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        
        int N = Integer.parseInt(br.readLine());
        
        while(N -- > 0){
            set.add(br.readLine());
        }
        
        List<String> list = new ArrayList<>(set);
        
        Collections.sort(list, (a, b) -> {
            if(a.length() != b.length()){
                return a.length() > b.length() ? 1 : -1;
            }
            return a.compareTo(b);
        });
        
        for(String str: list){
            sb.append(str).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}