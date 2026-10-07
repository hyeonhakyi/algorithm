import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int devleopDay = (100 - progresses[0] + speeds[0] - 1) / speeds[0];
        
        int count = 1;
        
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < progresses.length; i++){
            int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            
            if(day <= devleopDay){
                count++;
            }else{
                list.add(count);
                
                devleopDay = day;
                count = 1;
            }
        }
        
        list.add(count);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }//solution end
}//class end