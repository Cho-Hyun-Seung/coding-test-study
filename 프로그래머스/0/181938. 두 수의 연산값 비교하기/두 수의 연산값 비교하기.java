class Solution {
    public int solution(int a, int b) {
        int case1 = Integer.parseInt(""+a+b);
        int case2 = 2*a*b;
        int answer = Math.max(case1,case2);
        return answer;
    }
}