import java.util.*;
import java.io.*;
// 뱀~~
public class Main{
    private static int N;
    private static int[][] board;
    private static List<Turn> turnPoint;
    private static Deque<int[]> snake;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int dir = 1;
    
    private static class Turn{
        int time;
        char dir;
        
        Turn(int time, char dir){
            this.time = time;
            this.dir = dir;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        turnPoint = new ArrayList<>();
        
        N = Integer.parseInt(br.readLine());
        
        board = new int[N + 1][N + 1];
        snake = new ArrayDeque<>();
        snake.add(new int[]{1, 1});
        board[1][1] = 2;
        
        // 사과 배치하기
        int countApple = Integer.parseInt(br.readLine());
        for(int i = 0; i < countApple; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = 1;
        }
        
        // 도는 위치 List 넣어주기
        int countMove = Integer.parseInt(br.readLine());
        for(int i = 0; i < countMove; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char turn = st.nextToken().charAt(0);
            turnPoint.add(new Turn(time, turn));
        }
        
        // 시뮬레이션 시작
        int curTime = 0;
        while(true){
            curTime += 1;
            boolean isStrike = move(curTime);
            if(!isStrike){
                break;
            }
        }
        System.out.println(curTime);
    }
    
    private static boolean move(int curTime){
        int[] head = snake.getFirst();
        int[] nextHead = new int[]{head[0] + dx[dir], head[1] + dy[dir]};
        
        // 다음 위치가 몸이나 벽에 부딫히는지 확인
        if(!isValid(nextHead)){
            return false;
        }
        
        // 사과가 있는 경우
        if(board[nextHead[0]][nextHead[1]] == 1){
            snake.addFirst(nextHead);
            board[nextHead[0]][nextHead[1]] = 2;
        } else{
            // 없으면 꼬리 지워주기
            snake.addFirst(nextHead);
            board[nextHead[0]][nextHead[1]] = 2;
            int[] tail = snake.removeLast();
            board[tail[0]][tail[1]] = 0;
        }
        
        for(Turn turn: turnPoint){
            if(turn.time == curTime){
                if(turn.dir == 'L'){
                    dir += 1;
                    if(dir == 4){
                        dir = 0;
                    }
                } else{
                    dir -=1;
                    if(dir == -1){
                        dir = 3;
                    }
                }
            }
        }
        return true;
    }
    
    
    private static boolean isValid(int[] head){
        // 맵 밖으로 나갈 경우
        if(head[0] < 1 || head[0] > N || head[1] < 1 || head[1] > N){
            return false;
        }
        
        // 몸에 부딫힌 경우
        if(board[head[0]][head[1]] == 2){
            return false;
        }
        return true;
    }
    
}