import java.util.*;

class Solution {
    private static List<Set<Integer>> dp;
    public int solution(int N, int number) {
        int answer = 0;
        
        dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<Integer>());
        }

        for (int i = 1; i <= 8; i++) {
            int num = 0;
            for (int k = 0; k < i; k++) {
                num = num * 10 + N;
            }
            dp.get(i).add(num);

            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }
            if (dp.get(i).contains(number)) return i;
        }

        return -1;
    }
}
