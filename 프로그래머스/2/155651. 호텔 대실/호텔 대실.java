import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] time = new int[24 * 60 + 10];
        
        for(String[] room : book_time){
            String start = room[0];
            String end = room[1];
            
            time[cal(start)] += 1;
            time[cal(end) + 10] -= 1;
        }
        
        for(int i = 1; i < time.length; i++){
            time[i] += time[i - 1];
            answer = Math.max(answer,time[i]);
        }
        
        return answer;
    }
    
    public static int cal(String time){
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        
        return (h * 60) + m;
    }
}