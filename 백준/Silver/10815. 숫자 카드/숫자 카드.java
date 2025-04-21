import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        HashSet<Integer> set = new HashSet<>();
        
        // 상근이가 가지고 있는 숫자 카드의 개수
        int N = Integer.parseInt(br.readLine());
        
        // 숫자 카드에 적혀있는 정수 (+, - 가 있고 딱봐도 큼)
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                sb.append(1);
            }else{
                sb.append(0);
            }
            sb.append(" ");
        }
        
        System.out.println(sb.toString());
    }
}