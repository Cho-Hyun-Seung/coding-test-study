import java.util.*;
/*
    한번에 2명, 무게 제한 존재
    최대한 적게 사용하여 모든 사람 구출
    !!투포인터로 풀기
*/

class Solution {
    private static boolean[] visited;
    
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(people);
        
        // 1. 투포인터 지정
        int left = 0;
        int right = people.length - 1;
        int temp = 0;
        
        while (left <= right) {
            // 가장 무거운 + 가벼운
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                // 가장 무거운
                right--;
            }
            answer++; // 보트 한 척 사용
        }
        
        return answer;
    }
}