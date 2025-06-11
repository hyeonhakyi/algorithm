import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toUpperCase();
            
            if(q.remove(city)){
                q.offer(city);
                answer++;
            }else{
                if(q.size() == cacheSize){
                    q.poll();
                    q.add(city);
                }else{
                    q.add(city);
                }
                answer += 5;
            }
        }
        
        
        return answer;
    }
}