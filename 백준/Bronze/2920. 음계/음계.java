import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean isAscending = false;
        boolean isDescending = false;
        int pastNum = Integer.parseInt(st.nextToken());
        if (pastNum == 8) isDescending = true;
        if (pastNum == 1) isAscending = true;
        while ((isAscending || isDescending) && st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (isAscending && pastNum + 1 != num) {
                isAscending = false;
                break;
            }
            if (isDescending && pastNum - 1 != num) {
                isDescending = false;
                break;
            }
            pastNum = num;
        }
        System.out.println(isAscending ? "ascending" : isDescending ? "descending" : "mixed");
    }
}