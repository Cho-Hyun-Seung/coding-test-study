class Solution {
    public int solution(int[][] sizes) {
        int maxX = 0;
        int maxY = 0;

        for (int[] v : sizes) {
            int bigger = Math.max(v[0], v[1]);
            int smaller = Math.min(v[0], v[1]);

            maxX = Math.max(maxX, bigger);
            maxY = Math.max(maxY, smaller);
        }

        return maxX * maxY;
    }
}