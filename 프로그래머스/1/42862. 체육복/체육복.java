import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);
        
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int l : lost) lostSet.add(l);
        for (int r : reserve) reserveSet.add(r);

        for (int i = 1; i <= n; i++) {
            if (lostSet.contains(i) && reserveSet.contains(i)) {
                lostSet.remove(i);
                reserveSet.remove(i);
            }
        }

        for (int num : lostSet) arr[num]--;
        for (int num : reserveSet) arr[num]++;

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                if (i > 1 && arr[i - 1] == 2) {
                    arr[i]++;
                    arr[i - 1]--;
                } else if (i < n && arr[i + 1] == 2) {
                    arr[i]++;
                    arr[i + 1]--;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] >= 1) answer++;
        }

        return answer;
    }
}
