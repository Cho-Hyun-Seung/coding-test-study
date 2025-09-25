import java.util.*;
/*
    - 세로 n줄, 가로로 m줄
    - 최소 1면이 외부와 연결된 컨테이너에서 해당 종류 모두 꺼냄
    -   근데 BB처럼 들어오면 다 꺼냄;
    - 모든 요청 완료 후 남은 컨테이너 수 출력
*/
class Solution {
    static char[][] store;
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        N = storage.length;
        M = storage[0].length();
        answer = N * M;
        store = new char[N][M];
        
        for(int i = 0; i < N; i++){
            store[i] = storage[i].toCharArray();
        }
        
        for(String req : requests){
            // 한단어 인 경우
            if(req.length() == 1){
                answer -= singleCode(req.charAt(0));
            } else {
                answer -= doubleCode(req.charAt(0));
            }
        }

        return answer;
    }
    
    public void print(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(store[i][j] + " ");
            }
            // System.out.println();
        }
        // System.out.println();
    }
    
    
    // 한 글자가 들어온 경우
    public int singleCode(char code){
        int popContainer = 0;
        List<int[]> toEmpty = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                // 코드가 일치하면서 하차 가능한 경우
                if(store[i][j] == code && (isEdge(i, j) || aroundEmpty(i, j))){
                    // store[i][j] = '*';
                    toEmpty.add(new int[]{i, j});
                    // 주변에 '-'가 있으면 *로
                    // makeEmpty(i, j);
                    popContainer += 1;
                }
            }
        }
        
        for(int[] arr: toEmpty){
            store[arr[0]][arr[1]] = '*';
            makeEmpty(arr[0], arr[1]);
        }
        
        return popContainer;
    }
    
    // 두 글자가 들어온 경우
    public int doubleCode(char code){
        int popContainer = 0;
        List<int[]> toEmpty = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                // 코드가 일치하면서 하차 가능한 경우
                if(store[i][j] == code){
                    // 주변에 빈 공간이 있으면 *로 아니면 -로
                    store[i][j] = (isEdge(i, j) || aroundEmpty(i, j)) ? '*' : '-';
                    if(store[i][j] == '*') toEmpty.add(new int[]{i, j});
                    popContainer += 1;
                }
            }
        }
        
        for(int[] arr: toEmpty){
            store[arr[0]][arr[1]] = '*';
            makeEmpty(arr[0], arr[1]);
        }
        
        return popContainer;
    }
    
    // 시작이 모퉁이인 경우 체크
    public boolean isEdge(int y, int x) {
        return (y == 0 || y == N - 1 || x == 0 || x == M - 1);
    }
    
    // 주변이 공백인 경우 체크
    public boolean aroundEmpty(int y, int x) {
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isValid(ny, nx) && store[ny][nx] == '*'){
                return true;
            }
        }
        
        return false;
    }
    
    // 가운데 뺀 경우 연결해서 다 지우기
    public void makeEmpty(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(ny, nx) && store[ny][nx] == '-') {
                store[ny][nx] = '*';
                q.offer(new int[]{ny, nx});
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (isValid(ny, nx) && store[ny][nx] == '-') {
                    store[ny][nx] = '*';
                    q.offer(new int[]{ny, nx});
                }
            }
        }
    }
    
    // 배열 오버플로 언더 플로 체크
    public boolean isValid(int y, int x){
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}