import java.util.*;
import java.io.*;

public class Main {
    private static int N, C;
    private static LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 1.횟수 저장
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. 정렬
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Integer, Integer> entry : list) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}