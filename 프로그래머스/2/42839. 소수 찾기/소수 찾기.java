import java.util.*;

class Solution {
    private static String[] numArr;
    private static boolean[] visited;
    private static Set<Integer> set;

    public int solution(String numbers) {
        set  = new HashSet<>();
        numArr = numbers.split("");
        visited = new boolean[numArr.length];

        for(int i = 1; i <= numArr.length; i++){
            numGenerator("", i);
        }

        return set.size();
    }

    private static void numGenerator(String now, int size){
        if(now.length() == size){
            int num = Integer.parseInt(now);
            if(isDecimal(num)){
                set.add(num);
            }
            return;
        }

        for(int i = 0; i < numArr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                numGenerator(now + numArr[i], size);
                visited[i] = false;
            }
        }
    }

    private static boolean isDecimal(int num){
        if(num < 2) return false;

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }
}
