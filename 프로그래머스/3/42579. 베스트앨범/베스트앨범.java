import java.util.*;
import java.util.stream.*;
/*
    - 베스트 엘범에 들어갈 노래의 고유 번호 순서대로 return
*/
class Solution {
    private static HashMap<String, Integer> map;
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        map = new HashMap<>();
        
        // 총 재생 횟수 계산
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 재생 순 정렬
        List<Map.Entry<String, Integer>> entries = map
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toList());
        
        List<Integer> answerList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: entries){
            String genre = entry.getKey();
            
            List<int[]> songs = new ArrayList<>();
            
            // 같은 장르 모으기
            for(int i = 0; i < genres.length; i++){
                if(genres[i].equals(genre)){
                    songs.add(new int[]{i, plays[i]});
                }
            }
            
            // 내림차순 정렬 + 같으면 i 순
            songs.sort((a, b) -> {
                if(a[1] == b[1]){
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });
            
            for(int i = 0; i < Math.min(songs.size(), 2); i++){
                answerList.add(songs.get(i)[0]);
            }
        }
        
        answer = answerList.stream().mapToInt(v -> v).toArray();
        return answer;
    }
}