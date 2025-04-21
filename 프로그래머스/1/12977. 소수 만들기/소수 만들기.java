import java.util.*;

class Solution {
    private static boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num %i == 0){
                return false;
            }
        }
        return true;
    }
    
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    list.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        for(int num: list){
            if(isPrime(num)){
                answer +=1;
            }
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(answer);

        return answer;
    }
}