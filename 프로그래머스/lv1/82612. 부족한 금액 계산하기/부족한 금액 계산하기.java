class Solution {
    public long solution(int price, int money, int count) {
        
        long total = (long) price * count * (count + 1) / 2;
        
        if (money >= total) {
            return 0;
        }
        
        return total - money;
    }
}