import java.util.*;
import java.io.*;

public class Main{
    private static final String A = "AAAA";
    private static final String B = "BB";
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] arr = br.readLine().split("\\.", -1);
        
        for(int i = 0; i < arr.length; i++){
            String node = arr[i];
            int nodeLength = node.length();
            if(canCovered(nodeLength)){
                // 4보다 크거나 같은 경우
                if(nodeLength >= 4){
                    sb.append(buildNode(nodeLength));
                } else if(nodeLength == 2) {
                    sb.append(B);
                }
                
            } else{
                System.out.println("-1");
                return;
            }
            if (i < arr.length - 1) {
                sb.append(".");
            }
        }
        System.out.println(sb.toString());
        
    }
    
    private static boolean canCovered(int nodeLength){
        // 불가 조건 1
        if(nodeLength % 2 != 0){
            return false;
        }
        
        return true;
    }
    
    private static String buildNode(int nodeLength){
        int ACount = nodeLength / 4;
        int BCount = (nodeLength % 4) / 2;
        
        return A.repeat(ACount) + B.repeat(BCount);
    }
}

