/*
T : 테스트 데이터 수
H : 호텔의 층 수 |  W : 각 층의 방 수 | N : 몇번째 손님인지 
*/

import java.util.Scanner;

public class Main{  
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        while(testCase-- > 0){
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();
            // 여기서 모듈러 연산으로 인해 0이 나올 수 있음!
            int guestH = n % h == 0? h : n%h;
            int guestW  = (int)Math.ceil(1.0*n/h);
            String room = "" + guestH + (guestW > 9 ? guestW :"0" + guestW);
            System.out.println(room);
        }
    }
}