import java.util.*;
import java.io.*;

public class Main{
    private static int COL = 12;
    private static int ROW = 6;
    private static char[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    public static class Dots{
        public int x, y;
        
        Dots(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int combo = 0;
        
        arr = new char[COL][ROW];
        
        for(int i = 0; i < COL; i++){
            arr[i] = br.readLine().toCharArray();
        }
        

        while(true){
            // 돌면서 터뜨리기
            visited = new boolean[COL][ROW];
            List<List<Dots>> popList = new ArrayList<>();
            
            for(int i = 0; i < COL; i++){
                for(int j = 0; j < ROW; j++){
                    if(isValid(j, i)){
                        List<Dots> list = bfs(j, i);
                        // 터뜨려야 할 경우
                        if(list.size() >=4){
                            popList.add(list);
                        }
                    }
                }
            }
            // 터뜨릴 요소가 없는 경우
            if(popList.size() <=0) break;
            
            
            // 터뜨려주기
            for(List<Dots> dotList : popList){
                for(Dots dot: dotList){
                    arr[dot.y][dot.x] = '.';
                }
            }
            
            // 바닥으로 끌어 내리기
            fillBlank();
            
            // 콤보 올리기
            combo += 1;
        }
        
        System.out.println(combo);
        
    }
    
    private static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < COL; i++){
            for(int j = 0; j < ROW; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        System.out.println(sb.toString());
    }
    
    private static void fillBlank(){
        // 세로 한 줄 씩 검사하기
        for(int i = 0; i < ROW; i++){
            int bottom = COL -1;
            // 아래로 내리기
            for(int j = COL -1; j >= 0 ; j--){
                if(arr[j][i] != '.'){
                    arr[bottom][i] = arr[j][i];
                    bottom -=1;
                }
            }
            
            for(int j = bottom; j >= 0; j--){
                arr[j][i] = '.';
            }
            
        }
    }
    
    private static boolean isValid(int x, int y){
        return x >= 0 && x < ROW
            && y >= 0 && y < COL
            && !visited[y][x]
            && arr[y][x] != '.';
    }
    
    private static List<Dots> bfs(int x, int y){
        Queue<Dots> queue = new LinkedList<>();
        // 큐에 값 넣기
        queue.offer(new Dots(y, x));
        // 방문처리 하기
        visited[y][x] = true;
        
        // 리턴할 리스트
        List<Dots> list = new ArrayList<>();
        
        while(!queue.isEmpty()){
            Dots cur = queue.poll();
            list.add(cur);
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                // 값 검증하기
                if(isValid(nx, ny)&& arr[ny][nx] == arr[cur.y][cur.x]){
                    Dots target = new Dots(ny, nx);
                    // 큐에 넣기
                    queue.offer(target);
                    // 방문 처리하기
                    visited[ny][nx] = true;
                }
            }
        }
        
        return list;
    }
}