import java.util.Scanner;
/*
    세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 
    0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
*/
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10]; // count 수를 위한 배열
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int num = a * b * c;
        String strNum = "" + num;

        for(int i = 0; i < strNum.length(); i++){
            int idx = strNum.charAt(i) - '0';
            arr[idx] +=1;
        }

        for(int i = 0; i < arr.length; i ++){
            System.out.println(arr[i]);
        }
    }
}