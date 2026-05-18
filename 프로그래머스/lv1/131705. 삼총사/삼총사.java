class Solution {
    public int solution(int[] number) {
        return recursive(number, 0, 0, 0);
    }

    private int recursive(int[] arr, int idx, int count, int sum) {

        if (count == 3) {
            return sum == 0 ? 1 : 0;
        }

        int result = 0;

        for (int i = idx; i < arr.length; i++) {
            result += recursive(
                arr,
                i + 1,
                count + 1,
                sum + arr[i]
            );
        }

        return result;
    }
}