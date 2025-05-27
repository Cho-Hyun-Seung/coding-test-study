import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] isDeleted;
    static int leafCount = 0;
    static int root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        isDeleted = new boolean[N];

        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int child = 0; child < N; child++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = child;
            } else {
                tree.get(parent).add(child);
            }
        }

        int deleteNode = Integer.parseInt(br.readLine());

        deleteSubtree(deleteNode);

        if (!isDeleted[root]) {
            countLeafNodes(root);
        }

        System.out.println(leafCount);
    }

    static void deleteSubtree(int node) {
        isDeleted[node] = true;
        for (int child : tree.get(node)) {
            deleteSubtree(child);
        }
    }

    static void countLeafNodes(int node) {
        int liveChildCount = 0;

        for (int child : tree.get(node)) {
            if (!isDeleted[child]) {
                countLeafNodes(child);
                liveChildCount++;
            }
        }

        if (liveChildCount == 0) {
            leafCount++;
        }
    }
}
