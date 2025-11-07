import java.util.*;
/*
    - 닉네임 변경 방법
        1. 챗방 나간 후 새로운 닉으로 접속
        2. 채팅방에서 닉네임 변경
        => 닉네임 변경 시 기존 메시지도 모두 변경
        
    record 문자열
    - [상태] [uid] [닉네임]
*/
class Solution {
    Map<String, String> map;
    List<String> uid;
    List<String> message;
    
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        map = new HashMap<>();
        uid = new ArrayList<>();
        message = new ArrayList<>();
        StringTokenizer st;
        
        for (String r : record) {
            st = new StringTokenizer(r);
            String cmd = st.nextToken();
            String id = st.nextToken();
            String name = null;
            
            switch (cmd) {
                case "Enter":
                    name = st.nextToken();
                    enter(id, name);
                    break;
                case "Leave":
                    leave(id);
                    break;
                case "Change":
                    name = st.nextToken();
                    change(id, name);
                    break;
            }
        }
        
        for (int i = 0; i < uid.size(); i++) {
            String msg = map.get(uid.get(i)) + message.get(i);
            answer.add(msg);
        }
        
        return answer.toArray(new String[0]);
    }
    
    private void enter(String id, String name) {
        uid.add(id);
        message.add("님이 들어왔습니다.");
        map.put(id, name);
    }
    
    private void leave(String id) {
        uid.add(id);
        message.add("님이 나갔습니다.");
    }
    
    private void change(String id, String name) {
        map.put(id, name);
    }
}