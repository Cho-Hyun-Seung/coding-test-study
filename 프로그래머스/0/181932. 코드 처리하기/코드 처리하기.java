/*
- 문자열 code가 주어짐
- code를 앞에서 부터 읽다가 만약 문자가 "1"이면 mode 변경
- mode에 따라 code를 읽어가면서 문자열 ret을 만들어냄
- 시작 mode = 0

mode 조건
- mode == 0
    code[idx] != "1" => idx가 짝수일 때만 ret의 맨 뒤에 code[idx] 추가
    code[idx] == "1" => mode = 1
- mode == 1
    code[idx] != "1" => idx가 홀수일 때만 ret의 맨 뒤에 code[idx] 추가
    code[idx] == "1" => mode = 0
    
return 조건
    ret이 빈 문자열이면 "EMPTY" return
*/

class Solution {
    public String solution(String code) {
        String ret = "";
        int mode = 0;
        
        for(int idx = 0; idx < code.length(); idx++){
            char ch = code.charAt(idx);
            if(mode == 0){
                if (ch == '1'){
                    mode = 1;
                }else if(idx%2 == 0){
                    ret += ch;
                }else{
                    continue;
                }
            }else{
                if (ch == '1'){
                    mode = 0;
                }else if(idx%2 == 1){
                    ret += ch;
                }else{
                    continue;
                }
            }
        }
        return ret.length() == 0 ? "EMPTY": ret;
    }
}