import java.util.*;
import java.io.*;

public class Main{
    private static int N;
    private static List<Integer> primeList;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        primeList = new ArrayList<>();
        // 소수 리스트 만들어주기
        makePrimeList();
        
        System.out.println(twoPointer());
    }
    
    private static void makePrimeList(){
        boolean[] primeArr = new boolean[N + 1];
        for(int i = 2; i <= Math.sqrt(N); i++){
            // 소수 인경우
            if(primeArr[i] == false){
                for(int j = i*i; j <= N; j+=i){
                    primeArr[j] = true;
                }
            }
        }
        
        for(int i = 2; i <= N ; i++){
            if(!primeArr[i]){
                primeList.add(i);
            }
        }
    }
    
    private static int twoPointer(){
        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 0;
        
        while(true){
            // N 이상인 경우
            if(sum >= N){
                // 도달 한 경우
                if(sum == N) answer += 1;
                sum -= primeList.get(left++);
            } else {
                if(right == primeList.size()) {
                    break;
                }
                sum += primeList.get(right++);
            }
        }
        
        return answer;
    }
}