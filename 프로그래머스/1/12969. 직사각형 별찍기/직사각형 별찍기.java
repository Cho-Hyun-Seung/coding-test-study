import java.util.Scanner;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i= 0; i < b; i++){
            sb.append("*".repeat(a)).append("\n");
        }
        

        System.out.println(sb.toString());
    }
}