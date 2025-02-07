//TODO answer를 조건문 안에 선언 하거나 
//     answer를 동적으로 선언해야 함!
// 1. 2의 갯수를 센다!
// 2. for문으로 돌린다!
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int count_two = 0;
        // 1. 2의 갯수 세기
        for(int n : arr){
            if(n == 2) count_two ++;
        }
        if(count_two == 0){
            answer.add(-1);
        }
        else if(count_two == 1){
            answer.add(2);
        }else{
            int start_idx = -1;
            int end_idx = -1;
            for(int i = 0; i < arr.length; i ++){
                if(arr[i] == 2 && start_idx == -1){
                    start_idx = i;
                }
                else if(arr[i] == 2 && start_idx != -1){
                    end_idx = i;
                }
            }
            for(int i = start_idx; i <= end_idx; i++){
                answer.add(arr[i]);   
            }
            
        }
        
        return answer.stream().mapToInt(v->v).toArray();
    }
}