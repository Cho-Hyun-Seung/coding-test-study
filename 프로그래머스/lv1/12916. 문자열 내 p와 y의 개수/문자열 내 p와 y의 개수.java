class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        int count = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'p' || arr[i] == 'P'){
                count += 1;
            } else if (arr[i] == 'y' || arr[i] == 'Y'){
                count -= 1;
            }
        }
                

        return count == 0;
    }
}