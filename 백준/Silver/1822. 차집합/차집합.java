import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aN = Integer.parseInt(st.nextToken());
        int bN = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < aN; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < bN; i++){
            set.remove(Integer.parseInt(st.nextToken()));
        }
        
        sb.append(set.size()).append("\n");
        
        if(set.size() > 0){
            List<Integer> list = set.stream()
                .sorted(Integer::compare)
                .collect(Collectors.toList());
            for(int num: list){
                sb.append(num).append(" ");
            }
        }
        
        System.out.println(sb.toString());
    }
}