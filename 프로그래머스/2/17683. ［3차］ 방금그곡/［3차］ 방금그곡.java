import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxLen = 0;
        
        m = replace(m);
        
        for(int i = 0; i < musicinfos.length; i++){
            String[] arr = musicinfos[i].split(",");
            
            String start = arr[0];
            String end = arr[1];
            String title = arr[2];
            String target = replace(arr[3]);
            
            int time = change(start,end);
            
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < time; j++){
                sb.append(target.charAt(j % target.length()));
            }
            
            if(sb.toString().contains(m)){
                if(time > maxLen){
                    maxLen = time;
                    answer = title;
                }
            }
        }
        
        return answer;
    }//solution end
    
    private static int change(String start,String end){
        String[] s = start.split(":");
        int sTime = (Integer.parseInt(s[0]) * 60) + Integer.parseInt(s[1]);
        
        String[] e = end.split(":");
        int eTime = (Integer.parseInt(e[0]) * 60) + Integer.parseInt(e[1]);
        
        return eTime - sTime;
    }//change end
    
    private static String replace(String str){
        str = str.replace("C#", "c");
        str = str.replace("D#", "d");
        str = str.replace("F#", "f");
        str = str.replace("G#", "g");
        str = str.replace("A#", "a");
        
        return str;
    }//replace end
}//class end