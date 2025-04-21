import java.util.*;
/*
["######","###  #","##  ##","#### ","#####","### # "]
["######","###  #","##  ##"," #### "," #####","### # "]

*/
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb;
        
        for(int i = 0; i < n; i++){
            sb = new StringBuilder();
            String map = makeMap(arr1[i], arr2[i]);
            map = "0".repeat(n-map.length()) + map;
            for(char c: map.toCharArray()){
                if(c == '0'){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    
    // 지도 합치기 코드
    private static String makeMap(int a, int b){     
        return Integer.toBinaryString(a | b);
    }
}