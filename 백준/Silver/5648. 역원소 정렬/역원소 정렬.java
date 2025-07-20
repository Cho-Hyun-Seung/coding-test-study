import java.util.*;
import java.io.*;

public class Main {
    private static List<Long> list;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        while (list.size() < N) {
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                String reversed = new StringBuilder(token).reverse().toString();
                list.add(Long.parseLong(reversed));
            }
            if (list.size() < N) {
                st = new StringTokenizer(br.readLine());
            }
        }

        Collections.sort(list);

        for (long num : list) {
            sb.append(num).append('\n');
        }
        System.out.print(sb);
    }
}
