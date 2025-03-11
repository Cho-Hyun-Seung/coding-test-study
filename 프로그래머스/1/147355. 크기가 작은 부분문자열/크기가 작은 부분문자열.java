class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long length = p.length();
        for(int i = 0; i <= t.length()- length; i++){
            long sliceNum = Long.parseLong(t.substring(i, (int)(i + length)));
            if(sliceNum <= Long.parseLong(p)) {
                answer += 1;
            }
        }
        return answer;
    }
}