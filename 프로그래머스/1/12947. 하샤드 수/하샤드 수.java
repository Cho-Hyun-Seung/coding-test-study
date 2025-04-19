import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(int x) {
        String[] strList = ("" + x).split("");
        int sum = 0;
        for(String str: strList){
            sum += Integer.parseInt(str);
        }
        return x%sum == 0 ? true : false;
    }
}