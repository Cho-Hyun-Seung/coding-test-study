import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int length = Integer.parseInt(br.readLine());
        
        int[] roads = new int[length - 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < roads.length; i++){
            roads[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] oils = new int[length];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < oils.length; i++){
            oils[i] = Integer.parseInt(st.nextToken());
        }
        
        int nowOils = 0;    // 현재 오일 잔여량
        int cost = 0;
        
        for(int i = 0; i < roads.length; i++){
            // 최소 요구치 충족 여부 확인
            if(roads[i] > nowOils){
                nowOils +=roads[i];
                cost += roads[i] * oils[i];
            }
            
            // 남은 주유소들보다 지금이 쌀 경우
            for(int j = i + 1 ; j <roads.length; j++){
                if(oils[i] < oils[j]){
                    nowOils += roads[j];
                    cost += oils[i] * roads[j];
                }else{
                    break;
                }
            }
            nowOils -= roads[i];
        }
        System.out.println(cost);
    }
}