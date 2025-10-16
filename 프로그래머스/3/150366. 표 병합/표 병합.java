import java.util.*;


class Solution {
    private int N = 50;
    private int rc = 5050;
    private int[] union;
    private String[] value;
    
    private int find(int x){
        if(union[x] == x) return x;
        return union[x] = find(union[x]);
    }
    
    private int toCoord(int r, int c){
        return r * 100 + c;
    }
    
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        
        union = new int[rc + 1];
        value = new String[rc + 1];
        
        // 유니온 파인드 준비하기!
        for(int r = 1; r <= 50; r++){
            for(int c = 1; c <= 50; c++){
                int idx = toCoord(r, c);
                union[idx] = idx;
                value[idx] = null;
            }
        }
        
        StringTokenizer st;
        for(String command: commands){
            String[] cmdArr = command.split(" ");
            
            switch(cmdArr[0]){
                case "UPDATE":
                    if(cmdArr.length == 4) updateOne(cmdArr);
                    else if(cmdArr.length == 3) updateAll(cmdArr);
                    break;
                case "MERGE":
                    merge(cmdArr);
                    break;
                case "UNMERGE":
                    unmerge(cmdArr);
                    break;
                case "PRINT":
                    String v = print(cmdArr);
                    answer.add((v == null) ? "EMPTY" : v);
                    break;
            }
        }
        
        return answer.toArray(String[]::new);
    }
    
    // r, c의 위치를 value로 update
    // TODO 병합 여부 체크하기!! - 완료
    private void updateOne(String[] cmdArr){
        int r = Integer.parseInt(cmdArr[1]);
        int c = Integer.parseInt(cmdArr[2]);
        String v = cmdArr[3];
        
        int idx = toCoord(r, c);
        int root = find(idx);
        
        value[root] = v;
    }
    
    // value1을 값으로 가지고 있는 모든 셀을 value2로 바꿈
    // TODO 병합 여부 체크하기!! - 완료
    private void updateAll(String[] cmdArr){
        String v1 = cmdArr[1];
        String v2 = cmdArr[2];
        
        for(int i = 1; i <= 50; i++){
            for(int j = 1; j <= 50; j++){
                int cur = toCoord(i, j);
                if(union[cur] == cur && v1.equals(value[cur])){
                    value[cur] = cmdArr[2];
                }
            }
        }
    }
    
    /*
        - r1,c1 과 r2, c2 위치의 셀을 선택하여 병합
        - 두 위치의 셀이 같을 경우 무시
        - 한 셀이 값을 가진 경우 병합된 셀은 그 값을 가짐
        - 두 셀 모두 값을 가진 경우 병합된 셀은 r1, c1 위치의 값을 가짐
        - 이후 r1, c1 r2, c2 어느 위치를 선택해도 병합된 셀로 접근
    */
    private void merge(String[] cmdArr){
        int r1 = Integer.parseInt(cmdArr[1]);
        int c1 = Integer.parseInt(cmdArr[2]);
        int r2 = Integer.parseInt(cmdArr[3]);
        int c2 = Integer.parseInt(cmdArr[4]);
        
        
        
        int idx1 = toCoord(r1, c1);
        int idx2 = toCoord(r2, c2);
        
        if(idx1 == idx2) return;
        
        int root1 = find(idx1);
        int root2 = find(idx2);
        
        String value1 = value[root1];
        String value2 = value[root2];
        
        String temp = (value1 != null) ? value1 : value2;
        
        union[root2] = union[root1];
        // 부모에서 value를 찾을 거니 null 처리!
        value[root2] = null;
        value[root1] = temp;
        
        return;
    }
    
    // r, c 위치의 셀을 선태갛여 해당 셀의 모든 병합 해제
    // 값을 가지고 있을 경우 r, c위치의 셀이 그 값을 가지게 됨
    private void unmerge(String[] cmdArr){
        int r = Integer.parseInt(cmdArr[1]);
        int c = Integer.parseInt(cmdArr[2]);
        
        int idx = toCoord(r, c);
        
        int root = find(idx);
        String temp = value[root];
        
        List<Integer> member = new ArrayList<>();
        
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                int cur = toCoord(i, j);
                // 자신의 그룹인 경우
                if(find(cur) == root){
                    member.add(cur);
                }
            }
        }
        
        // 멤버들 null로 만들기!
        for(int m : member){
            union[m] = m;
            value[m] = null;
        }
        
        value[idx] = temp;
        
        return;
    }
    
    private String print(String[] cmdArr){
        int r = Integer.parseInt(cmdArr[1]);
        int c = Integer.parseInt(cmdArr[2]);
        
        int idx = toCoord(r, c);
        
        int root = find(idx);
        
        return value[root];
    }
}