import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> hashmap = new HashMap<>();
        // hashmap에 데이터 추가하기!
        for(int i = 0; i< name.length; i++) {
            hashmap.put(name[i], yearning[i]);
        }
        
        for(int i = 0; i < photo.length; i++) {
            for(String info: photo[i]){
                if(hashmap.containsKey(info)){ 
                    answer[i] += hashmap.get(info);
                }
            }
        }
        
        return answer;
    }
}