import java.util.*;
import java.io.*;

public class Main {
    private static List<Integer> lanCables;
    private static int needLanCable;

    private static int findMaxSize() {
        long left = 1; // 최소 1
        long right = Collections.max(lanCables);
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            // 개수 세기
            for (int lanCable : lanCables) {
                count += lanCable / mid;
            }

            // 개수가 충분한 경우
            if (count >= needLanCable) {
                answer = mid;
                left = mid + 1;
                // 개수가 부족한 경우
            } else {
                right = mid - 1;
            }
        }
        return (int)answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ownLanCable = Integer.parseInt(st.nextToken());
        needLanCable = Integer.parseInt(st.nextToken());

        lanCables = new ArrayList<>();
        for (int i = 0; i < ownLanCable; i++) {
            lanCables.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(findMaxSize());
    }
}
