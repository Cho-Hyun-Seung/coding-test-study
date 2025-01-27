import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        // 변수 i를 만들어 초기값을 0으로 설정한 후
        int i = 0;
        
        // i가 arr의 길이보다 작으면 다음 작업을 반복합니다.
        while(i < arr.length){
            // 만약 stk가 빈 배열이라면 arr[i]를 stk에 추가하고 i에 1을 더합니다.
            if(stk.size() == 0){
                stk.add(arr[i]);
                i +=1;
            //stk에 원소가 있고, stk의 마지막 원소가 arr[i]보다 작으면 
            // arr[i]를 stk의 뒤에 추가하고 i에 1을 더합니다.
            }else if(stk.size() > 0 && stk.get(stk.size()-1) < arr[i]){
                stk.add(arr[i]);
                i +=1;
            }else{
                stk.remove(stk.size()-1);
            }
        }
        return stk.stream().mapToInt(v -> v).toArray();
    }
}