import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static int[] box;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    private static LinkedHashSet<List<Integer>> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        box = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        picker(0);

        for (List<Integer> list : set) {
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void picker(int depth) {
        if(depth == M){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < M ; i++){
                temp.add(box[i]);
            }
            set.add(temp);
            return;
        }

        for(int i = 0; i < N; i++){
            if (!visited[i]) {
                visited[i] = true;
                box[depth] = arr[i];
                picker(depth + 1);
                visited[i] = false;
            }
        }
    }
}
