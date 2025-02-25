import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int maxPad = 1;
        int step = 1;
        for(step = 1; maxPad < num; step++){
            maxPad += 6*step;
        }
        System.out.println(step);
    }
}