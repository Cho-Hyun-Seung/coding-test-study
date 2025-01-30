import java.util.*;
/*
    code    : 코드번호
    date    : 제조일
    maximum : 최대 수량
    remain  : 현재 수량
    
    val_ext : 정보 기준
    sort_by : 정렬할 기준이 되는 문자열
-- data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, 
-- sort_by에 해당하는 값을 기준으로 오름차순으로 정렬
*/
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList<>();
        String[] data_info = {"code", "date", "maximum", "remain"};
        int target_ext_idx = Arrays.asList(data_info).indexOf(ext);
        int target_sort_idx = Arrays.asList(data_info).indexOf(sort_by);
        // 1. 데이터 뽑기
        for(int i = 0; i < data.length; i ++){
            if(data[i][target_ext_idx] < val_ext){
                answer.add(data[i]);
            }
        }
        // 2. 데이터 정렬
        answer.sort(Comparator.comparingInt(a -> a[target_sort_idx]));

        return answer.toArray(new int[answer.size()][]);
    }
}