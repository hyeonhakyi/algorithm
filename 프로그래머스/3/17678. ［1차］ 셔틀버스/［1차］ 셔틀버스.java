import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] crew = new int[timetable.length];
        
        for(int i = 0; i < timetable.length; i++){
            crew[i] = toMinute(timetable[i]);
        }
        
        Arrays.sort(crew);
        
        int idx = 0;
        int answer = 0;
        for(int i = 0; i < n; i++){
            int busTime = 9 * 60 + (i * t);
            int count = 0;
            int prevTime = -1;
            
            while(idx < crew.length && busTime >= crew[idx] && count < m){
                prevTime = crew[idx];
                idx++;
                count++;
            }
            
            if(i == n - 1){
                if(count < m){
                    answer = busTime;
                }else{
                    answer = prevTime - 1;
                }   
            }
        }
        
        return toTime(answer);
    }//solution end
    
    private static int toMinute(String time){
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]) * 60;
        int minute = Integer.parseInt(split[1]);
        return hour + minute;
    }//toMinute end
    
    private static String toTime(int value){
        int time = value / 60;
        int minute = value % 60;
        return String.format("%02d:%02d",time,minute);
    }//toTime end
}//class end