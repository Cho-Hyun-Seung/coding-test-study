import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = findMin(arr);

        return Arrays.stream(arr)
                .filter(v -> v != min)
                .toArray();
    }

    public int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int num : arr) {
            if (min > num) {
                min = num;
            }
        }

        return min;
    }
}