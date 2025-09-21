import java.util.*;
/*
    선물을 주고 받은 기록이 있는 경우?
    => 두 사람 사이 더 많은 선물을 준사람이 다음달 선물 하나 획득
    
    받은 기록이 없거나 같은 경우?
    => 선물 지수가 큰 사람이 작슨 사람한테 선물 하나 받음
    => 지수도 같은 경우 선물을 주고 받지 않음
*/

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        
        int[][] giftLog = new int[N][N];
        // 인덱스 입력을 위한 해시맵
        HashMap<String, Integer> idx = new HashMap<>();
        // 선물 지수
        int[] giftPoint = new int[N];
        
        for(int i = 0; i < N; i++){
            idx.put(friends[i],i);
        }
        
        // 기프트 기록 입력
        StringTokenizer st;
        for(String gift: gifts){
            st = new StringTokenizer(gift);
            int fromIdx = idx.get(st.nextToken());
            int toIdx = idx.get(st.nextToken());
            
            giftLog[fromIdx][toIdx] += 1;
            giftPoint[fromIdx] += 1;
            giftPoint[toIdx] -= 1;
        }
        
        // 선물 많이 받는 사람 찾기
        List<Integer> getGift = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            getGift.add(0);
        }
        
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                // 기록이 있는 경우? + 주고 받은 횟수가 다른 경우
                if(giftLog[i][j] != giftLog[j][i] && 
                   (giftLog[i][j] != 0 || giftLog[j][i] != 0)){
                    if(giftLog[i][j] > giftLog[j][i]) getGift.set(i, getGift.get(i) + 1);
                    if(giftLog[j][i] > giftLog[i][j]) getGift.set(j, getGift.get(j) + 1);
                } else{
                    // 지수가 같은 경우
                    if (giftPoint[i] == giftPoint[j]) continue;
                    if (giftPoint[i] > giftPoint[j]) {
                        getGift.set(i, getGift.get(i) + 1);
                    } else {
                        getGift.set(j, getGift.get(j) + 1);
                    }
                }
            }
        }
        
        return getGift.stream().mapToInt(Integer::intValue).max().orElse(0);
    }
}