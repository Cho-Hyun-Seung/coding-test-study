import java.util.*;

class Solution {
    int[] month = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] arr = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    public String solution(int a, int b) {
        String answer = "";
        int day = b - 1;
        for(int i = 0; i < a - 1; i++){
            day += month[i];
        }
        return arr[day % 7];
    }
}