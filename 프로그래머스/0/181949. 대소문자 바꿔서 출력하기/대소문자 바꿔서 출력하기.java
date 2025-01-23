import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        for(int idx=0; idx < a.length(); idx++){
            char alpha = a.charAt(idx);
            answer += Character.isUpperCase(alpha)
                ? Character.toLowerCase(alpha)
                : Character.toUpperCase(alpha);
        }
        
        System.out.println(answer);
    }
}