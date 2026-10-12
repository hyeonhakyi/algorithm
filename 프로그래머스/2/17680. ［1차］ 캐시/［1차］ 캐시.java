import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        Queue<String> q = new LinkedList<>();
        
        for(int i = 0; i < cities.length; i++){
            String str = cities[i].toLowerCase();
            
            if(q.contains(str)){
                answer += 1;
                
                q.remove(str);
                q.offer(str);
            }else{
                answer += 5;
                
                if(q.size() >= cacheSize){
                    q.poll();
                }
                
                q.offer(str);
            }
        }
        
        return answer;
    }//solution end
}//class end