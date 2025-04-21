import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> first = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> second = Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5);
        List<Integer> third = Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);
        int[] answer = {};
        
        int answer1 = correct(first, answers);
        int answer2 = correct(second, answers);
        int answer3 = correct(third, answers);
        List<Integer> grade = Arrays.asList(answer1, answer2, answer3);
        List<Integer> result = new ArrayList<>();
        int maxValue = grade.stream().mapToInt(v->v).max().orElse(0);
        for(int i = 0; i < grade.size(); i++){
            if(grade.get(i) == maxValue){
                result.add(i+1);
            }
        }
        
        answer = result.stream().mapToInt(v->v).toArray();
        
        
        
        return answer;
    }
    
    private static int correct(List<Integer> list, int[] answers){
        int count = 0;
        for(int i = 0; i < answers.length; i++){
            int idx = i % list.size();
            if(list.get(idx) == answers[i]) count++;
        }
        
        return count;
    }
}