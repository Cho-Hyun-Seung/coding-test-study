class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        // 배열 복사
        System.arraycopy(num_list, 0, answer, 0, num_list.length);
        
        int last_num = num_list[num_list.length -1];    // 마지막 숫자
        int last_last_num = num_list[num_list.length -2];   // 마마지막 숫자
        if(last_num > last_last_num){
            answer[answer.length - 1] = last_num - last_last_num;
        }else{
            answer[answer.length - 1] = last_num*2;
        }
        return answer;
    }
}