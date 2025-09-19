import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = makeQueue(queue1);
        Queue<Integer> q2 = makeQueue(queue2);
        long sumOfQ1 = sumQueue(q1);
        long sumOfQ2 = sumQueue(q2);

        // 합이 홀수일 경우
        if ((sumOfQ1 + sumOfQ2) % 2 == 1) return -1;

        int maxChange = (q1.size() + q2.size()) * 4;
        while (sumOfQ1 != sumOfQ2) {
            if (answer == maxChange) {
                return -1;
            }
            if (sumOfQ1 > sumOfQ2) {
                int num = q1.poll();
                q2.offer(num);
                sumOfQ1 -= num;
                sumOfQ2 += num;
            } else {
                int num = q2.poll();
                q1.offer(num);
                sumOfQ1 += num;
                sumOfQ2 -= num;
            }
            answer++;
        }
        return answer;
    }

    public Queue<Integer> makeQueue(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int n : arr) {
            queue.offer(n);
        }
        return queue;
    }

    public long sumQueue(Queue<Integer> queue) {
        long sum = 0;
        for (int n : queue) {
            sum += n;
        }
        return sum;
    }
}
