import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        int n = progresses.length;
        int currentDay = cal(progresses[0],speeds[0]);
        int count = 1;
        
        for(int i = 1; i < n; i++){
            int day = cal(progresses[i],speeds[i]);
            
            if(day <= currentDay){
                count++;
            }else{
                list.add(count);
                currentDay = day;
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
    
    private static int cal(int progresse,int speed){
        return (100 - progresse + speed - 1) / speed;
    }//cal end
}//class end