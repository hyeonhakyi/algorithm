import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0){
            return cities.length * 5;
        }
        int answer = 0;
        
        Queue<String> q = new LinkedList<>();
        
        for(int i = 0; i < cities.length; i++){
            String citiy = cities[i].toUpperCase();
            
            if(q.remove(citiy)){
                q.offer(citiy);
                answer++;
            }else{
                if(cacheSize == q.size()){
                    q.poll();
                    q.add(citiy);
                }else{
                    q.add(citiy);
                }
                answer = answer + 5;
            }
        }
        
        return answer;
    }
}