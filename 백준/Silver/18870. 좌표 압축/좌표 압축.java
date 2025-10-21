import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        List<Integer> info = new ArrayList<>();
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            info.add(num);
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for (int i : info) {
            int idx = binarySearch(list, i);
            sb.append(idx).append(" ");
        }
        
        System.out.println(sb.toString());
    }
    
    private static int binarySearch(List<Integer> list, int num) {
        int start = 0;
        int end = list.size() - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int temp = list.get(mid);
            
            if (temp == num) {
                return mid;
            } else if (temp > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
