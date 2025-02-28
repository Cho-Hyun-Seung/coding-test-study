import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int numSize = Integer.parseInt(br.readLine());
        int[] arr = new int[numSize];

        for(int i = 0; i < numSize; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        /* 시간 초과 */
        // Arrays.stream(arr).sorted().forEach(v -> System.out.println(v));
        Arrays.sort(arr);
        for(int i : arr){
            sb.append(i + "\n");
        }
        
        System.out.println(sb.toString());
    }
}