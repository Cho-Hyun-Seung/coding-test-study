import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int correctNum = 0;
        int unknownNum = 0;

        Set<Integer> winSet = new HashSet<>();
        for (int num : win_nums) {
            winSet.add(num);
        }

        for (int num : lottos) {
            if (num == 0) {
                unknownNum++;
            } else if (winSet.contains(num)) {
                correctNum++;
            }
        }

        int maxCorrect = correctNum + unknownNum;
        int minCorrect = correctNum;

        return new int[]{getRank(maxCorrect), getRank(minCorrect)};
    }

    private int getRank(int correct) {
        return correct >= 2 ? 7 - correct : 6;
    }
}
