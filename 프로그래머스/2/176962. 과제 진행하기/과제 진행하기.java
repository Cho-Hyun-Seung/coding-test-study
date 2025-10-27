import java.util.*;

class Solution {

    static class Task {
        String title;
        int start;
        int remain;

        Task(String title, int start, int playtime) {
            this.title = title;
            this.start = start;
            this.remain = playtime;
        }
    }

    public String[] solution(String[][] plans) {
        List<Task> tasks = new ArrayList<>();
        for (String[] p : plans) {
            tasks.add(new Task(p[0], toMinutes(p[1]), Integer.parseInt(p[2])));
        }
        tasks.sort(Comparator.comparingInt(t -> t.start));

        List<String> answer = new ArrayList<>();
        Deque<Task> paused = new ArrayDeque<>();

        for (int i = 0; i < tasks.size() - 1; i++) {
            Task cur = tasks.get(i);
            int timeGap = tasks.get(i + 1).start - cur.start;

            // 현재 과제 먼저 처리
            if (cur.remain <= timeGap) {
                timeGap -= cur.remain;
                answer.add(cur.title); 

                // 남은 시간으로 스택에서 이어서 처리
                while (timeGap > 0 && !paused.isEmpty()) {
                    Task rest = paused.pop();
                    if (rest.remain <= timeGap) {
                        timeGap -= rest.remain;
                        answer.add(rest.title);
                    } else {
                        rest.remain -= timeGap;
                        timeGap = 0;
                        paused.push(rest);
                    }
                }
            } else {
                // 다 못 끝내면 남은 시간을 줄이고 스택에 보관
                cur.remain -= timeGap;
                paused.push(cur);
            }
        }

        // 마지막 과제부터 끝내고, 스택 비우기
        Task last = tasks.get(tasks.size() - 1);
        answer.add(last.title);
        while (!paused.isEmpty()) {
            answer.add(paused.pop().title);
        }

        return answer.toArray(new String[0]);
    }

    private int toMinutes(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
}
