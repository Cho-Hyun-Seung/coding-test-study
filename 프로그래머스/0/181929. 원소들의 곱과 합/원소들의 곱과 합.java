class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int case1 = 1; // 모든 원소 곱
        int case2 = 0; // 모든 원소들의 합의 제곱
        
        for(int num:num_list){
            case1 *= num;
            System.out.println(case1);
            case2 += num;
        }
        
        
        return case1 < Math.pow(case2,2)? 1 :0;
    }
}