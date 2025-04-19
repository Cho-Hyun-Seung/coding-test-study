import java.io.*;
import java.util.*;

class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int size = phone_number.length();
        
        sb.append("*".repeat(size-4))
            .append(phone_number.substring(size-4));
        
        return sb.toString();
    }
}