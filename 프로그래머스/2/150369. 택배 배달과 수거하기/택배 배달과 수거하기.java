class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0L;

        int dIdx = n - 1;
        int pIdx = n - 1;

        while (true) {
            while (dIdx >= 0 && deliveries[dIdx] == 0) dIdx--;
            while (pIdx >= 0 && pickups[pIdx] == 0) pIdx--;

            if (dIdx < 0 && pIdx < 0) break;

            int dist = Math.max(dIdx, pIdx) + 1;
            answer += (long) dist * 2;

            int dStore = cap;
            while (dStore > 0 && dIdx >= 0) {
                if (deliveries[dIdx] == 0) { dIdx--; continue; }
                int take = Math.min(deliveries[dIdx], dStore);
                deliveries[dIdx] -= take;
                dStore -= take;
                if (deliveries[dIdx] == 0) dIdx--;
            }

            int pStore = cap;
            while (pStore > 0 && pIdx >= 0) {
                if (pickups[pIdx] == 0) { pIdx--; continue; }
                int take = Math.min(pickups[pIdx], pStore);
                pickups[pIdx] -= take;
                pStore -= take;
                if (pickups[pIdx] == 0) pIdx--;
            }
        }

        return answer;
    }
}
