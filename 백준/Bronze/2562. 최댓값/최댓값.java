import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int maxNum = 0;
        int maxNumCount = 0;
        int count = 0;

        while(sc.hasNext()){
            int num = sc.nextInt();
            count += 1;
            if(num > maxNum){
                maxNum = num;
                maxNumCount = count;
            }
        }

        System.out.println(maxNum);
        System.out.println(maxNumCount);
    }
}