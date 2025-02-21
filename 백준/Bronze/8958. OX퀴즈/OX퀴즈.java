/*
첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고,
길이가 0보다 크고 80보다 작은 문자열이 주어진다. 
문자열은 O와 X만으로 이루어져 있다.
*/


import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int testCase = sc.nextInt();
        
        while(testCase-- > 0){
            int score = 0; // 총 점수
            int point = 1; // 정답 시 획득 포인트
            char[] submitOX = sc.next().toCharArray();
            for(char ch : submitOX){
                if(ch == 'O'){
                    score += point++;
                }else{
                    point = 1;
                }
            }
            System.out.println(score);
        }
    }
}