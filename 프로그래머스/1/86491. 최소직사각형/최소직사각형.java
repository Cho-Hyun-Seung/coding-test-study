class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        // 큰게 세로 작은게 가로로 고정
        int minW = Math.min(sizes[0][0], sizes[0][1]);
        int minH = Math.max(sizes[0][0], sizes[0][1]);
        
        for(int i = 1; i < sizes.length; i++){
            int W = Math.min(sizes[i][0], sizes[i][1]);
            int H = Math.max(sizes[i][0], sizes[i][1]);
            
            minW = Math.max(minW, W);
            minH = Math.max(minH, H);
        }
        return minW*minH;
    }
}