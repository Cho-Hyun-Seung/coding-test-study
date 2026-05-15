import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        
        while(b-- > 0 ) sb.append("*".repeat(a)).append("\n");
        
        System.out.println(sb.toString());
    }
}