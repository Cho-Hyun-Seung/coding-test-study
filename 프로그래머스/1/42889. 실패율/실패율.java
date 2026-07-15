import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] rest = new int[N + 2];

        // 각 스테이지에 머물러 있는 플레이어 수
        for (int num : stages) {
            rest[num]++;
        }

        double[] failRatio = new double[N + 1];
        int players = stages.length;

        for (int i = 1; i <= N; i++) {
            if (players == 0) {
                failRatio[i] = 0;
            } else {
                failRatio[i] = (double) rest[i] / players;
            }

            players -= rest[i];
        }

        Integer[] stageNumbers = new Integer[N];

        for (int i = 0; i < N; i++) {
            stageNumbers[i] = i + 1;
        }

        Arrays.sort(stageNumbers, (a, b) -> {
            int result = Double.compare(failRatio[b], failRatio[a]);

            // 실패율이 같으면 작은 스테이지 번호부터
            return result != 0 ? result : Integer.compare(a, b);
        });

        return Arrays.stream(stageNumbers)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}