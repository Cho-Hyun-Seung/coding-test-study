class Solution {
    public int solution(int n) {
        return func1(n);
    }

    public int func1(int num) {
        StringBuilder sb = new StringBuilder();

        while(num > 0){
            sb.append(num % 3);
            num /= 3;
        }

        String reversed = sb.toString();

        int result = 0;

        for(int i = 0; i < reversed.length(); i++){
            int digit = reversed.charAt(reversed.length() - 1 - i) - '0';
            result += digit * Math.pow(3, i);
        }

        return result;
    }
}