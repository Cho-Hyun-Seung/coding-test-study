class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        String[] str_arr = my_string.split("");
        
        for(int num: indices){
            str_arr[num] = "";
        }
        
        for(String str: str_arr){
            answer += str;
        }
        return answer;
    }
}

// import java.util.*;
// import java.util.stream.Collectors;

// class Solution {
//     public String solution(String my_string, int[] indices) {
//         String answer = "";
//         List<Integer> indices_list = Arrays.stream(indices).boxed().collect(Collectors.toList());
//         for(int i = 0; i < my_string.length(); i++){
//             if(!indices_list.contains(i)){
//                 answer += my_string.charAt(i);
//             }
//         }
//         return answer;
//     }
// }