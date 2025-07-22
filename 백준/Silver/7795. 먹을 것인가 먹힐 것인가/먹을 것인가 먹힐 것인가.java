import java.util.*;
import java.io.*;

public class Main {
    private static int T;
    private static BufferedReader br;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int aSize = Integer.parseInt(st.nextToken());
            int bSize = Integer.parseInt(st.nextToken());

            int[] aArr = new int[aSize];
            int[] bArr = new int[bSize];

            fillArray(aArr, br.readLine());
            fillArray(bArr, br.readLine());

            int result = countPair(aArr, bArr);
            System.out.println(result);
        }
    }
    
    // 배열을 채우고, 정렬
    private static void fillArray(int[] arr, String numStr) {
        st = new StringTokenizer(numStr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }

    // 정렬된 배열을 넘겨 받음
    private static int countPair(int[] from, int[] to) {
        int result = 0;
        int j = 0;
        for (int i = 0; i < from.length; i++) {
            while (j < to.length && from[i] > to[j]) {
                j++;
            }
            result += j;
        }
        return result;
    }
}
