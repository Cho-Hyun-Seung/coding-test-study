import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[] unf;
    
    static int find(int x){
        if (unf[x] == x) return x;
        return unf[x] = find(unf[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a != b) unf[b] = a;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        unf = new int[N + 1];
        for(int i = 1; i <= N; i++){
            unf[i] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        int knownLength = Integer.parseInt(st.nextToken());
        int[] known = new int[knownLength];
        for (int i = 0; i < knownLength; i++){
            known[i] = Integer.parseInt(st.nextToken());
        }

        
        List<List<Integer>> party = new ArrayList<>();
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            
            List<Integer> p = new ArrayList<>(cnt);
            
            for (int j = 0; j < cnt; j++){
                p.add(Integer.parseInt(st.nextToken()));
            };
            
            party.add(p);
            
            for (int j = 1; j < p.size(); j++){
                union(p.get(0), p.get(j));
            }
        }
        
        boolean[] knownParent = new boolean[N + 1];
        for (int knownP : known){
            knownParent[find(knownP)] = true;
        }
        
        int answer = 0;
        for (List<Integer> partyList : party){
            boolean ok = true;
            for (int p : partyList){
                if (knownParent[find(p)]){
                    ok = false; // 진실 전파됨
                    break;
                }
            }
            if (ok) answer++;
        }

        System.out.println(answer);
        
    }
}