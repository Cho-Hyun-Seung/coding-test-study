import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 1. 스테이지별 도전자 수 기록
        int[] challengers = new int[N + 2];

        for (int stage : stages) {
            challengers[stage]++;
        }

        // 현재 스테이지에 도달한 사용자 수
        int rest = stages.length;
        double[] fail = new double[N + 1];

        // 2. 실패율 계산
        for (int stage = 1; stage <= N; stage++) {
            if (rest == 0) {
                fail[stage] = 0;
            } else {
                fail[stage] = (double) challengers[stage] / rest;
            }

            // 현재 스테이지에서 실패한 사용자는 다음 스테이지에 도달하지 못함
            rest -= challengers[stage];
        }

        // Comparator를 사용하기 위해 Integer[] 사용
        Integer[] stageNumbers = new Integer[N];

        for (int i = 0; i < N; i++) {
            stageNumbers[i] = i + 1;
        }

        // 3. 실패율 내림차순, 같으면 스테이지 번호 오름차순
        Arrays.sort(stageNumbers, (a, b) -> {
            int result = Double.compare(fail[b], fail[a]);

            if (result == 0) {
                return Integer.compare(a, b);
            }

            return result;
        });

        return Arrays.stream(stageNumbers)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}