/* 
다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 
이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. 
c는 1로, d는 2로, ..., C를 8로 바꾼다.

1부터 8까지 차례대로 연주한다면 ascending, 
8부터 1까지 차례대로 연주한다면 descending, 
둘 다 아니라면 mixed 이다.
*/

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 1번 번호로 처음 필터링
        int prevNum = sc.nextInt();

        if(prevNum == 1){
            while(sc.hasNext()){
                int nextNum = sc.nextInt();
                if(isAsc(prevNum, nextNum)){
                    prevNum = nextNum;
                }else{
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("ascending");
        }else if (prevNum == 8){
            while(sc.hasNext()){
                int nextNum = sc.nextInt();
                if(isDesc(prevNum, nextNum)){
                    prevNum = nextNum;
                }else{
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }

    }

    public static boolean isAsc(int prevNum, int nextNum){
        return prevNum + 1 == nextNum;
    }

    public static boolean isDesc(int prevNum, int nextNum){
        return prevNum - 1 == nextNum;
    }
}


