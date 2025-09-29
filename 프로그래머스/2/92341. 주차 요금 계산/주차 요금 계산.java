import java.util.*;

class Solution {
    static HashMap<String, Integer> charge;
    static HashMap<String, Integer> log;
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        
        charge = new HashMap<>();
        log = new HashMap<>();
        
        StringTokenizer st;
        for(String record: records){
            st = new StringTokenizer(record);
            int time = toMinutes(st.nextToken());
            String carNum = st.nextToken();
            String status = st.nextToken();
            
            // 입차
            if(status.equals("IN")){
                // 로그에 추가하기
                log.put(carNum, time);
                
            } else { // 출차
                // 요금 계산하기
                int parkingTime = time - log.get(carNum);
                // 요금 기록에 넣어 주기
                charge.put(carNum, charge.getOrDefault(carNum, 0) + parkingTime);
                log.remove(carNum);
            }
        }
        
        // 안나간 차들 처리해주기
        List<String> list = new ArrayList<>(log.keySet());
        int endOfDay = toMinutes("23:59");
        for (String carNum : new ArrayList<>(log.keySet())) {
            int parkingTime = endOfDay - log.get(carNum);
            charge.put(carNum, charge.getOrDefault(carNum, 0) + parkingTime);
        }
        
        List<String> carList = new ArrayList<>(charge.keySet());
        Collections.sort(carList);
        
        answer = new int[carList.size()];
        for(int i = 0; i < answer.length; i++){
            int totalMinutes = charge.get(carList.get(i));
            answer[i] = calculateFee(totalMinutes, fees);
        }
        
        return answer;
    }
    
    public int calculateFee(int time, int[] fees){
        // 기본 시간에 포함되는 경우
        if(time <= fees[0]){
            return fees[1];
        } else {
            // 초과 요금 = 초과 시간/단위시간 (올림) * 초과 분당 요금
            int over = (int)Math.ceil((time - fees[0])/ (double)fees[2]);
            return fees[1] + over * fees[3];
        }
    }
    
    
    // 시각을 분으로 바꾸는 함수
    public int toMinutes(String time){
        String[] timeArr = time.split(":");
        
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
}