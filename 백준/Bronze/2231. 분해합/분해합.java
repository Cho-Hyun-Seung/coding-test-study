import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0; i < num; i++){
            int test = i;
            for(char ch: String.valueOf(i).toCharArray()){
                test += ch - '0';
            }
            if(num == test){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}