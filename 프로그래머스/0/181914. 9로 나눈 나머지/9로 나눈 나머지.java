// class Solution {
//     public int solution(String number) {
//         int answer = 0;
//         int sum = 0;
//         for(char ch: number.toCharArray()){
//             sum += Character.getNumericValue(ch);
//         }
//         answer = sum % 9;
//         return answer;
//     }
// }

class Solution {
    public int solution(String number) {
        int answer = number.chars().map(v -> Character.getNumericValue(v)).sum() % 9;
        return answer;
    }
}
    
    
    
    