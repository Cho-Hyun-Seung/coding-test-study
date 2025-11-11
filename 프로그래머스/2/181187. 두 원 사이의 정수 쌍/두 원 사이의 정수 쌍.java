import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            long y2 = (long) Math.floor(Math.sqrt((long) r2 * r2 - (long) x * x));
            long y1 = 0;

            if (x < r1) {
                y1 = (long) Math.ceil(Math.sqrt((long) r1 * r1 - (long) x * x));
            }

            answer += (y2 - y1 + 1);
        }

        return answer * 4;
    }
}
