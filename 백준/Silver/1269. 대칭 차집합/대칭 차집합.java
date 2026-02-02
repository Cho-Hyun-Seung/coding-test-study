import java.io.*;
import java.util.*;

public class Main {
    static boolean[] test = new boolean[100000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sizeA = Integer.parseInt(st.nextToken());
        int sizeB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (sizeA-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            test[num] = !test[num];
        }

        st = new StringTokenizer(br.readLine());
        while (sizeB-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            test[num] = !test[num];
        }

        int count = 0;
        for (boolean b : test) {
            if (b) count++;
        }

        System.out.println(count);
    }
}
