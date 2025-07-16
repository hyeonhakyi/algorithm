import java.util.*;

class Solution {
    private static final int max_time = 24 * 60 + 10;
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[] time = new int[max_time];
        
        for(String[] room: book_time){
            String start = room[0];
            String end = room[1];
            
            time[calcul(start)] += 1;
            time[calcul(end) + 10] -=1; 
        }
        
        for(int i = 1; i < time.length; i++){
            time[i] += time[i - 1];
            answer = Math.max(answer, time[i]);
        }
        
        return answer;
    }
    
    public int calcul(String time){
        String[] t = time.split(":");
        String h = t[0];
        String m = t[1];
        
        return ((Integer.parseInt(h) * 60) + Integer.parseInt(m));
    }
}