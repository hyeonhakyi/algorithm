import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = toSecond(play_time);
        int advSec = toSecond(adv_time);
        
        long[] time = new long[playSec + 2];
        
        for(String log : logs){
            String[] split = log.split("-");
            
            int start = toSecond(split[0]);
            int end = toSecond(split[1]);
            
            time[start] += 1;
            time[end] -= 1;
        }
        
        for (int i = 1; i <= playSec; i++) {
            time[i] += time[i - 1];
        }

        // 2차 누적합: 0초부터 i초까지의 누적 시청 시간
        for (int i = 1; i <= playSec; i++) {
            time[i] += time[i - 1];
        }
        
        long maxTimeCnt = time[advSec - 1];
        int answer = 0;
        
        for(int start = 1; start + advSec <= playSec; start++){
            int end = start + advSec - 1;
            
            long cnt = time[end] - time[start - 1];
            
            if(cnt > maxTimeCnt){
                maxTimeCnt = cnt;
                answer = start;
            }
        }
        
        return toTime(answer);
    }//solution end
    
    private static int toSecond(String time){
        String[] split = time.split(":");
        
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        int second = Integer.parseInt(split[2]);
        
        return hour * 3600 + minute * 60 + second;
    }//toSecond end
    
    private static String toTime(int time){
        int hour = time / 3600;
        time = time % 3600;
        
        int minute = time / 60;
        time = time % 60;
        
        return String.format("%02d:%02d:%02d",hour,minute,time);
    }//toTime end
}//class end