import java.util.*;
import java.io.*;

class Solution {
    private static HashMap<Character, Integer> map;

    public String solution(String[] survey, int[] choices) {
        map = new HashMap<>();
        StringBuilder answer = new StringBuilder();

        // 초기화
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            char[] arr = survey[i].toCharArray();
            checker(arr[0], arr[1], choices[i]);
        }

        answer.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        answer.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        answer.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        answer.append(map.get('A') >= map.get('N') ? 'A' : 'N');

        return answer.toString();
    }

    public static void checker(char first, char second, int choice) {
        if (choice == 4) return;

        int score = Math.abs(choice - 4);
        if (choice < 4) {
            map.put(first, map.get(first) + score); 
        } else {
            map.put(second, map.get(second) + score);
        }
    }
}
