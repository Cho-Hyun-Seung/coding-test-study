import java.util.*;
/*
    - update r c value : r,c 위치의 셀 선택하여 셀 값 변경
    - update value1 value2 : value1값 모두 선택해 value2로 변경
    - merge r1 c1 r2 c2 : (r1, c1)위치의 셀과 (r2, c2)위치의 셀 병합
        - 두 셀 중 한 셀이 값을 가진경우 병한된 셀은 그값을 가지게 됨
        - 둘다 값을 가진 경우 r1, c1 위치의 셀 값을 가지게 됨
        - 이후 두 셀 중 어느 위치를 선택해도 병합된 셀로 접근
    - unmerge r c : 병합 해제
    - print r c : 셀의 값 출력, 빈 경우 EMPTY 출력
    
    부모 요소로 가기? 유니온 파인드?
*/


class Solution {
    static final int N = 50;
    static final int rc = 5050;
    
    static int[] union = new int[rc + 1];
    static String[] value = new String[rc + 1];
    
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();

        for (int r = 1; r <= 50; r++) {
            for (int c = 1; c <= 50; c++) {
                int idx = toCoord(r, c);
                union[idx] = idx;
                value[idx] = null;
            }
        }

        for (String command : commands) {
            String[] arr = command.split(" ");
            
            switch (arr[0]) {
                case "UPDATE":
                    if (arr.length == 4) {
                        update(arr);
                    } else {
                        updateAll(arr);
                    }
                    break;
                    
                case "MERGE":
                    merge(arr);
                    break;
                    
                case "UNMERGE":
                    unmerge(arr);
                    break;
                    
                case "PRINT":
                    answer.add(print(arr));
                    break;
            }
        }
        return answer.toArray(new String[0]);
    }
    
    static int find(int x){
        if(union[x] == x) return x;
        return union[x] = find(union[x]);
    }
    
    static int toCoord(int r, int c){
        return r*100 + c;
    }
    
    static void update(String[] arr){
        int r = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        String v = arr[3];
        
        int coord = toCoord(r, c);
        
        // 병합된 경우도 있으니 루트에 값 넣어 주기
        int rootCoord = find(coord);
        value[rootCoord] = v;
    }
    
    static void updateAll(String[] arr){
        String v1 = arr[1];
        String v2 = arr[2];
        
        // 루트 값만 돌면서 확인해 주기!
        for (int i = 101; i <= rc; i++) {
            if (union[i] == i && v1.equals(value[i])) {
                value[i] = v2;
            }
        }
    }
    
    static void merge(String[] arr) {
        int r1 = Integer.parseInt(arr[1]);
        int c1 = Integer.parseInt(arr[2]);
        int r2 = Integer.parseInt(arr[3]);
        int c2 = Integer.parseInt(arr[4]);

        int i1 = toCoord(r1, c1);
        int i2 = toCoord(r2, c2);

        int p1 = find(i1);
        int p2 = find(i2);
        if (p1 == p2) return;

        String v1 = value[p1];
        String v2 = value[p2];
        String keep = (v1 != null) ? v1 : v2;

        union[p2] = p1;
        value[p2] = null;
        value[p1] = keep;
    }

    static void unmerge(String[] arr) {
        int r = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        int idx = toCoord(r, c);

        int root = find(idx);
        String keep = value[root];

        List<Integer> members = new ArrayList<>();
        for (int rr = 1; rr <= N; rr++) {
            for (int cc = 1; cc <= N; cc++) {
                int now = toCoord(rr, cc);
                if (find(now) == root) {
                    members.add(now);
                }
            }
        }

        for (int m : members) {
            union[m] = m;
            value[m] = null;
        }

        value[idx] = keep;
    }

    static String print(String[] arr) {
        int r = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);
        int idx = toCoord(r, c);
        int rootCoord = find(idx);
        return (value[rootCoord] == null) ? "EMPTY" : value[rootCoord];
    }
    
}