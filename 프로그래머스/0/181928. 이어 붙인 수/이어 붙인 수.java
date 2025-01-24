class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int odd = 0;
        int even = 0;
        for(int num: num_list){
            if(num %2 == 1){
                odd = odd*10+num;
            }else{
                even = even*10+num;
            }
        }
        return odd+even;
    }
}