import java.util.*;

class Solution {
    private static final int MAX_TIME = 24*60 + 10;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[] rooms = new int[MAX_TIME];
        
        for(String[] room:book_time){
            String start = room[0];
            String end = room[1];
            
            rooms[calcTime(start)] += 1;
            rooms[calcTime(end) + 10] -= 1;
        }
        
        for(int i = 1; i < rooms.length; i++){
            rooms[i] += rooms[i - 1];
            answer = Math.max(answer, rooms[i]);
        }
        
        return answer;
    }
    
    private static int calcTime(String time){
        String[] t = time.split(":");
        String hh = t[0];
        String mm = t[1];
        
        return ((Integer.parseInt(hh) * 60) + Integer.parseInt(mm));
    }
}