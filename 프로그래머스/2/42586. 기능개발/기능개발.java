import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        
        int n = progresses.length;
        int currentDay = getDay(progresses[0],speeds[0]);
        int count = 1;
        
        for(int i = 1; i < n; i++){
            int day = getDay(progresses[i],speeds[i]);
            
            if(day <= currentDay){
                count++;
            }else{
                result.add(count);
                currentDay = day;
                count = 1;
            }
        }
        
        result.add(count);
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }//solution end
    
    private static int getDay(int progresse,int speed){
        return (100 - progresse + speed - 1) / speed;
    }//getDay end
}//class end