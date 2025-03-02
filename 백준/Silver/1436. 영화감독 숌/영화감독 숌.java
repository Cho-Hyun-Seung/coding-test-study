import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seriesNum = Integer.parseInt(br.readLine());
        String endNum = "666";
        int now = 0;
        int result = 0;
        for(int i = 666; now != seriesNum;i++){
            if(("" + i).contains(endNum)){
                now +=1;
                result = i;
            }
        }
        System.out.println(result);
    }
}