/*
첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 
둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 
모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
*/
/*
첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.
*/
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int maxNum = -1000000;
        int minNum = +10000000;
        while(testCase-- > 0){
            int num = sc.nextInt();
            maxNum = Math.max(num, maxNum);
            minNum = Math.min(num, minNum);
        }
        System.out.println(minNum + " " + maxNum);
    }
}
