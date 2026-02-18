import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for(int i = 0; i < N; i++){
            arr[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(j + 1 < N){
                    swap(i, j, i, j + 1);
                    check();
                    swap(i, j, i, j + 1);
                }

                if(i + 1 < N){
                    swap(i, j, i + 1, j);
                    check();
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(answer);
    }

    static void swap(int y1, int x1, int y2, int x2){
        char temp = arr[y1][x1];
        arr[y1][x1] = arr[y2][x2];
        arr[y2][x2] = temp;
    }

    static void check(){
        for(int i = 0; i < N; i++){
            int count = 1;
            for(int j = 1; j < N; j++){
                if(arr[i][j] == arr[i][j-1]){
                    count++;
                } else {
                    answer = Math.max(answer, count);
                    count = 1;
                }
            }
            answer = Math.max(answer, count);
        }

        for(int j = 0; j < N; j++){
            int count = 1;
            for(int i = 1; i < N; i++){
                if(arr[i][j] == arr[i-1][j]){
                    count++;
                } else {
                    answer = Math.max(answer, count);
                    count = 1;
                }
            }
            answer = Math.max(answer, count);
        }
    }
}
