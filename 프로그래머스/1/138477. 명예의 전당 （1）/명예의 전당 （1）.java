/*
k 번째 이내이면 점수를 명예의 전당에 등록
매일 명예의 전당의 최하위 점수 발표
*/
import java.util.*;
import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new LinkedList<>();
        
        for(int i = 0; i < score.length; i++){
            list.add(score[i]);
            Collections.sort(list, Collections.reverseOrder());
            while(list.size() > k){
                list.remove(list.size() - 1);
            }
            answer[i] = list.get(list.size() - 1);
        }
        return answer;
    }
}