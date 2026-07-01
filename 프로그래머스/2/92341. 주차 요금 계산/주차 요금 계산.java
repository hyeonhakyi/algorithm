import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String,Integer> inMap = new HashMap<>();
        Map<String,Integer> totalMap = new HashMap<>();
        
        for(int i = 0; i < records.length; i++){
            String[] record = records[i].split(" ");
            
            int time = changeMinute(record[0]);
            String carNumber = record[1];
            String type = record[2];
            
            if(type.equals("IN")){
                inMap.put(carNumber,time);
            }else{
                int inTime = inMap.get(carNumber);
                int parkingTime = time - inTime;
                
                totalMap.put(carNumber, totalMap.getOrDefault(carNumber,0) + parkingTime);
                
                inMap.remove(carNumber);
            }
        }
        
        int endTime = changeMinute("23:59");
        
        for(String carNumber : inMap.keySet()){
            int inTime = inMap.get(carNumber);
            int parkingTime = endTime - inTime;
            
            totalMap.put(carNumber, totalMap.getOrDefault(carNumber, 0) + parkingTime);
        }
        
        List<String> cars = new ArrayList<>(totalMap.keySet());
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        
        for(int i = 0; i < cars.size(); i++){
            String carNumber = cars.get(i);
            int totalTime = totalMap.get(carNumber);
            
            answer[i] = calculateFee(totalTime,fees);
        }
        
        return answer;
    }//solution end
    
    private static int changeMinute(String time){
        String[] arr = time.split(":");
        
        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);
        
        return hour * 60 + minute;
    }//changeMinute end
    
    private static int calculateFee(int totalTime,int[] fees){
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        if(totalTime <= basicTime){
            return basicFee;
        }
        
        int extraTime = totalTime - basicTime;
        
        int extraCount = (extraTime + unitTime - 1) / unitTime;

        return basicFee + extraCount * unitFee;
    }
}//class end