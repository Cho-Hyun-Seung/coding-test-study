class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        for(int[] query: queries){
            String rev_sb = new StringBuilder(
                sb.substring(query[0], query[1] + 1)).reverse().toString();
            sb.replace(query[0], query[1] + 1, rev_sb);
        }
        return sb.toString();
    }
}