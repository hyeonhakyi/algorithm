import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        Queue<String> q = new LinkedList<>();
        
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            
            if (q.contains(city)) {
                answer += 1;

                q.remove(city);
                q.offer(city);
            } else {
                answer += 5;

                if (q.size() >= cacheSize) {
                    q.poll();
                }

                q.offer(city);
            }
        }
        
        return answer;
    }//solution end
}//class end