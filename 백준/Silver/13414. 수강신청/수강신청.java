import java.util.*;
import java.io.*;

public class Main{
    private static int K, L;    // 수강 가능 인원, 대기 목록 길이
    private static HashMap<String, Integer> map;
        
    public static void main(String[] args) throws IOException{
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        int count = 0;
        for(int i = 0; i < L; i++){
            String userId = br.readLine();
            map.put(userId, count++);
        }
        
        List<String> userIdList = new ArrayList<>(map.keySet());
        
        userIdList.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return map.get(o1) - map.get(o2);
            }
        });
        
        for(int i = 0; i < Math.min(K, userIdList.size()); i++){
            sb.append(userIdList.get(i)).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}