import java.util.*;
/*
    - 개인정보 유효기간 지나면 파기
    - 모든 달은 28일 까지!
    - term : "약관종류 유효기간"
    - privacies : "날짜 약관종류"
*/
class Solution {
    Map<String, Integer> term;
    int[] todayArr;
    int todayDays;

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        term = new HashMap<>();

        todayArr = Arrays.stream(today.split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();
        todayDays = toDays(todayArr[0], todayArr[1], todayArr[2]);

        // 약관 월수 맵
        for (String str : terms) {
            StringTokenizer st = new StringTokenizer(str);
            String type = st.nextToken();
            int months = Integer.parseInt(st.nextToken());
            term.put(type, months);
        }

        // 각 개인정보 만료 여부 확인
        for (int i = 0; i < privacies.length; i++) {
            StringTokenizer st = new StringTokenizer(privacies[i]);
            int[] inDay = Arrays.stream(st.nextToken().split("\\."))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            String type = st.nextToken();

            if (needDelete(inDay, type)) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(v -> v).toArray();
    }

    private int toDays(int y, int m, int d) {
        return (y - 1) * 12 * 28 + (m - 1) * 28 + d;
    }

    private boolean needDelete(int[] inDay, String type) {
        int termMonth = term.get(type);

        int collected = toDays(inDay[0], inDay[1], inDay[2]);
        int expire = collected + termMonth * 28 - 1;

        return todayDays > expire;
    }
}
