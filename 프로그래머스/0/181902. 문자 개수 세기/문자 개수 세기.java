class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(char ch: my_string.toCharArray()){
            int idx = ch < 97 ? ch - 65 : ch - 97 + 26;
            answer[idx]++;
        }
        return answer;
    }
}

// 처음 풀어본거
// import java.util.*;

// class Solution {
//     public int[] solution(String my_string) {
//         int[] answer = new int[52];
//         for(int i = 0; i < 26; i ++){
//             int upper_count = 0;
//             int lower_count = 0;
//             for(char ch:my_string.toCharArray()){
//                 if(ch-65 == i){
//                     upper_count +=1;
//                 }
//                 if(ch-97 == i){
//                     lower_count +=1;
//                 }
//             }
//             answer[i] = upper_count;
//             answer[i+26] = lower_count;
//         }
//         return answer;
//     }
// }