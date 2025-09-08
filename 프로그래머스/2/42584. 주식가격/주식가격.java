import java.util.*;

class Solution {
    
    class Node{
        int idx, price;
        
        Node(int idx, int price){
            this.idx = idx;
            this.price = price;
        }
    }
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Node> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++){
            // 큐가 비지 않았다면?
            while(!stack.isEmpty() && stack.peek().price > prices[i]){
                Node cur = stack.pop();
                answer[cur.idx] = i - cur.idx;
            }
            // 이후에 큐에 price 넣어주기
            stack.add(new Node(i, prices[i]));
        }
        
        // 스택 비워주기
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            answer[cur.idx] = prices.length - cur.idx - 1;
        }
        
        return answer;
    }
}