import java.util.*;
import java.io.*;

public class Main{
    private static int M,N;
    private static int[][] univ;
    private static int[][] rankedUniv;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        univ = new int[M][N+1];
        rankedUniv = new int[M][N + 1];
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                univ[i][j] = Integer.parseInt(st.nextToken());
            }
            rankingUniv(i);
        }
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < M; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= N; j++){
                sb.append(rankedUniv[i][j]).append("-");
            }
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        long result = 0L;
        for(int v: map.values()){
            result += 1L * v * (v - 1)/2;
        }
        
        System.out.println(result);
    }
    
    private static void rankingUniv(int idx){
        int[] sortedArr = new int[N];
        for(int j = 1; j <= N; j++){
            sortedArr[j - 1] = univ[idx][j];
        }
        Arrays.sort(sortedArr);
        
        Map<Integer,Integer> map = new HashMap<>();
        int rank = 0;
        for(int v : sortedArr){
            if(!map.containsKey(v)){
                map.put(v, rank++);
            }
        }
        
        for(int i = 1; i <= N; i++){
            rankedUniv[idx][i] = map.get(univ[idx][i]);
        }
    }
}