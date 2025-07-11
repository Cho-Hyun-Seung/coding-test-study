import java.util.*;
import java.math.*;
import java.io.*;

public class Main{
    private static final BigInteger M = new BigInteger("1234567891");
    private static final BigInteger R = new BigInteger("31");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());  // 문자열 길이
        String str = br.readLine();                    // 입력 문자열

        BigInteger hash = BigInteger.ZERO;
        BigInteger pow = BigInteger.ONE;

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - 'a' + 1;
            BigInteger term = BigInteger.valueOf(value).multiply(pow).mod(M);
            hash = hash.add(term).mod(M);
            pow = pow.multiply(R).mod(M); 
        }

        System.out.println(hash);
    }
}