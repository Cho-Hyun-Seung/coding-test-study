class Solution {
    public int solution(String[] babbling) {
        String[] dict = {"aya", "ye", "woo", "ma"};
        int answer = 0;

        for(String bab : babbling) {
            String prev = "";

            while(bab.length() > 0) {
                boolean found = false;

                for(String d : dict) {
                    if(bab.startsWith(d) && !prev.equals(d)) {
                        bab = bab.substring(d.length());
                        prev = d;
                        found = true;
                        break;
                    }
                }

                if(!found) break;
            }

            if(bab.length() == 0)
                answer++;
        }

        return answer;
    }
}