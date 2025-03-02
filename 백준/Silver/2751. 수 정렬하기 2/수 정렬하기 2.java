import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<>();
        while(size-- > 0){
            numList.add(Integer.parseInt(br.readLine()));
        }
        
        numList.stream().sorted().forEach(v -> sb.append(v).append('\n'));
        System.out.println(sb);
    }
}