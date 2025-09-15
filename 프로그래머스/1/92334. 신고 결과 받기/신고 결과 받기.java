import java.util.*;
/*
    - 각 유저는 한번에 한 명 신고 (동일 유저에 대한 신고 1회 처리)
    - k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 유저에게 메일 발송
    HashMap!
*/
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        StringTokenizer st;
        HashMap<String, HashSet<String>> whoSend = new HashMap<>();
        HashMap<String, Integer> idx = new HashMap<>();
        
        for(int i = 0; i < id_list.length; i++){
            idx.put(id_list[i], i);
        }
        
        for(String id: id_list){
            whoSend.put(id, new HashSet<>());
        }
        
        for(String rep: report){
            st = new StringTokenizer(rep);
            String from = st.nextToken();
            String to = st.nextToken();

            whoSend.get(to).add(from);
        }
        
        for(String id: id_list){
            HashSet<String> set = whoSend.get(id);
            if(set.size() >= k){
                for(String str: set){
                    answer[idx.get(str)] += 1;
                }
            }
        }
        
        return answer;
    }
}