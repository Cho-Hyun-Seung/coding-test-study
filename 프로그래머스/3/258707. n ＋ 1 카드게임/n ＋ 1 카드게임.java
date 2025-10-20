import java.util.*;

/*
    - 카드 n/3 장을 뽑아 모두 가짐
    - 라운드 시작할 때 카드를 두 장 뽑음
    - 카드 뭉치에 남은 카드가 없다면 게임 종료
    - 뽑은 카드 한 장당 동전 하나 소모해 가지거나 동전 소모 없이 버릴 수 있음
    - 카드에 적힌 수의 합이 n+1이 되도록 카드 두장을 내고 다음 라운드 진행 가능
    - 최대 라운드 수 return
*/

class Solution {
    private List<Integer> cardList;
    private int round;
    private int coin;
    private int[] cards;
    private int N;
    private boolean[] visited;
    private boolean next;
    
    public int solution(int coin, int[] cards) {
        int answer = 0;
        round = 1;
        cardList = new ArrayList<>();
        this.coin = coin;
        this.cards = cards;
        N = cards.length + 1;
        visited = new boolean[N];
        next = true;
        
        // 처음 카드 뽑기
        for(int i = 0; i < cards.length/3; i++){
            cardList.add(cards[i]);
        }
        
        for(int i = cards.length / 3; i < cards.length; i+= 2){
            cardList.add(cards[i]);
            cardList.add(cards[i + 1]);
            calculate();
            
            // 코인이 존재하지 않는 경우
            if(this.coin < 0 || !next){
                return round;
            }
            
            round += 1;
        }
        
        return round;
    }
    
    private void calculate(){
        // 가지고 있는 카드로 조합을 만들 수 있는 경우
        for(int i = 0; i < cards.length / 3; i++){
            for(int j = i + 1; j < cards.length / 3; j++){
                if(cardList.get(i) + cardList.get(j) == N 
                   && !visited[i] && !visited[j]){
                    visited[i] = true;
                    visited[j] = true;
                    return;
                }
            }
        }
        
        // 뽑은 수로 만들 수 있는 경우
        for(int i = 0; i < cardList.size(); i++){
            for(int j = i + 1; j < cardList.size(); j++){
                if(cardList.get(i) + cardList.get(j) == N 
                   && !visited[i] && !visited[j]){
                    visited[i] = true;
                    visited[j] = true;
                    
                    if(i >= cards.length / 3) coin -= 1;
                    if(j >= cards.length / 3) coin -= 1;
                    
                    return;
                }
            }
        }
        
        next = false;
    }
}