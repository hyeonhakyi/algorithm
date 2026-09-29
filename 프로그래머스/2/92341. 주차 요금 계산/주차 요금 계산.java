import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String,Integer> inMap = new HashMap<>();
        HashMap<String,Integer> totalMap = new HashMap<>();
        
        for(String str : records){
            String[] arr = str.split(" ");
            int time = inTime(arr[0]);
            String number = arr[1];
            String type = arr[2];
            
            if(type.equals("IN")){
                inMap.put(number,time);
            }else{
                int parkingTime = time - inMap.get(number);
                
                totalMap.put(number,totalMap.getOrDefault(number,0) + parkingTime);
                inMap.remove(number);
            }
        }
        
        int lastTime = inTime("23:59");
        
        for(String str : inMap.keySet()){
            int parkingTime = lastTime - inMap.get(str);
            totalMap.put(str,totalMap.getOrDefault(str,0) + parkingTime);
        }
        
        List<String> cars = new ArrayList<>(totalMap.keySet());
        Collections.sort(cars);
        int[] answer = new int[cars.size()];
        
        int idx = 0;
        for(String str : cars){
            int time = totalMap.get(str);
            if(time <= fees[0]){
                answer[idx++] = fees[1];
            }else{
                answer[idx++] = fees[1] + ((((time - fees[0]) + fees[2] - 1) / fees[2]) * fees[3]);
            }
        }
        
        return answer;
    }//solution end
    
    private static int inTime(String time){
        String[] arr = time.split(":");
        return (Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]));
    }//inTime end
}//class end