import java.util.*;
// import java.io.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        // 3진법으로 변환
        sb.append(Integer.toString(n, 3));
        String str = sb.toString();
        for(int i = 0; i < str.length(); i++){
            int num = str.charAt(i) - '0';
            answer += num * (int)Math.pow(3,i);
        }
        return answer;
    }
}