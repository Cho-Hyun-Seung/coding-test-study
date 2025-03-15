import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> hashset = new HashSet<>();

        List<String> answer = new LinkedList<>();

        for(int i = 0; i < n ; i++){
            hashset.add(br.readLine());
        }

        for(int i = 0; i < m; i++){
            String name = br.readLine();
            if(hashset.contains(name)) answer.add(name);
        }

        sb.append(answer.size()).append("\n");
        answer.sort((a,b) -> a.compareTo(b));

        for(String name: answer){
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}