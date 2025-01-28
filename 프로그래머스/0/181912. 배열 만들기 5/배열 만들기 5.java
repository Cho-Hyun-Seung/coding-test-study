import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();
        // s번 인덱스에서 시작하는 길이 l 짜리 문자열을 잘라내 정수로 변환
        for(String str: intStrs){
            int num = Integer.parseInt(str.substring(s, s+l));
            // 이때 k보다 큰 값들을 담은 배열 return
            if(num > k){
                answer.add(num);
            }
        }
        return answer.stream().mapToInt(v->v).toArray();
    }
}