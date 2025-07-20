import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

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
            System.out.println(num);
        }
    }
}
