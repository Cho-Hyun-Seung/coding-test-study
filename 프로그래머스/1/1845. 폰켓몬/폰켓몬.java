import java.util.*;
import java.util.stream.*;
import java.io.*;
/*
 - n마리 중에서 n/2마리 가져가도 됨
 - 최대한 다양한 종류의 폰켓몬 가지고자 함
 => return : 가장 많은 폰켓몬을 가지는 방법의 종류 수!
*/
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length/2;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        
        answer = size > set.size() ? set.size() : size;
        return answer;
    }
}