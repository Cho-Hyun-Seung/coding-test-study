import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;

        List<Integer> num_list = Arrays.asList(a, b, c, d);
        Set<Integer> int_set = new HashSet<>(num_list);

        // 모든 숫자가 같을 경우
        if (int_set.size() == 1) {
            answer = 1111 * a;
        } 
        // 서로 다른 숫자가 2개인 경우
        else if (int_set.size() == 2) {
            List<Integer> set_list = new ArrayList<>(int_set);
            int num1 = set_list.get(0);
            int num2 = set_list.get(1);

            int count1 = Collections.frequency(num_list, num1);
            int count2 = Collections.frequency(num_list, num2);

            // 3개가 같은 경우
            if (count1 == 3 || count2 == 3) {
                int p = (count1 == 3) ? num1 : num2;
                int q = (count1 == 1) ? num1 : num2;
                answer = (int) Math.pow(10 * p + q, 2);
            } 
            // 각각 2개씩 같은 경우
            else {
                answer = (num1 + num2) * Math.abs(num1 - num2);
            }
        } 
        // 서로 다른 숫자가 3개인 경우
        else if (int_set.size() == 3) {
            int product = 1;

            for (int num : int_set) {
                if (Collections.frequency(num_list, num) == 1) {
                    product *= num;
                }
            }
            answer = product;
        } 
        // 모든 숫자가 다른 경우
        else if (int_set.size() == 4) {
            answer = Collections.min(num_list);
        }

        return answer;
    }
}
