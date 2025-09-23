import java.util.*;
import java.util.stream.*;

class Solution {
    private Map<String, Integer> inMap;
    private Map<String, Integer> total;

    public int[] solution(int[] fees, String[] records) {
        inMap = new HashMap<>();
        total = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            int time = toMinutes(parts[0]);
            String car = parts[1];
            String state = parts[2];

            if (state.equals("IN")) {
                inMap.put(car, time);
            } else {
                int inTime = inMap.remove(car);
                total.put(car, total.getOrDefault(car, 0) + (time - inTime));
            }
        }

        // 내보내기
        for (String car : new ArrayList<>(inMap.keySet())) {
            int inTime = inMap.get(car);
            int time = toMinutes("23:59");
            total.put(car, total.getOrDefault(car, 0) + (time - inTime));
            inMap.remove(car);
        }

        // 차량 번호 오름차순으로 요금 계산
        List<String> cars = total.keySet().stream().sorted().collect(Collectors.toList());
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            answer[i] = calcFee(total.get(cars.get(i)), fees);
        }
        return answer;
    }

    private int calcFee(int totalMinutes, int[] fees) {
        int baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];
        if (totalMinutes <= baseTime) return baseFee;
        int extra = totalMinutes - baseTime;
        int units = (int) Math.ceil((double) extra / unitTime);
        return baseFee + units * unitFee;
    }

    private int toMinutes(String time) {
        String[] arr = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        return hour * 60 + min;
    }
}
