import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] expire = new int[24 + k + 1];
        
        int activeServer = 0;
        for(int hour = 0; hour < 24; hour++){
            activeServer -= expire[hour];
            
            int requireServer = players[hour] / m;
            if(activeServer < requireServer){
                int addServer = requireServer - activeServer;
                
                answer += addServer;
                activeServer += addServer;
                
                expire[hour + k] += addServer;
            }
        }
        
        return answer;
    }//solution end
}//class end