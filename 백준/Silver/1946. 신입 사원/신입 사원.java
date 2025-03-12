import java.util.*;
import java.io.*;
/*
1 4 O
2 5 X
3 6 X
4 2 O
5 7 X
6 1 O
7 3 X
*/

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine());
        
        while(testCase-- > 0){
            int count = 0;
            int length = Integer.parseInt(br.readLine());
            int[][] ranks = new int[length][2];
            for(int i =0; i < ranks.length; i++){
                st = new StringTokenizer(br.readLine());
                ranks[i][0] = Integer.parseInt(st.nextToken());
                ranks[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(ranks, (a ,b) -> a[0] - b[0]);
            int highB = ranks[0][1];
            count +=1;
            for(int i = 1; i < ranks.length; i++){
                if(ranks[i][1] < highB){
                    count +=1;
                    highB = ranks[i][1];
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}