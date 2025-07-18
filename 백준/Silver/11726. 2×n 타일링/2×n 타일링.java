import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        dp = new int[num + 1];

        if (num > 0) dp[1] = 1;
        if (num > 1) dp[2] = 2;

        System.out.println(tiling(num));
    }

    private static int tiling(int num) {
        for (int i = 3; i <= num; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        return dp[num];
    }
}
