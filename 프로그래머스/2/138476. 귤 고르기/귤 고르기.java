import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i : tangerine){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        
        List<Integer> counts = new LinkedList(map.values());
        
        counts.sort(Collections.reverseOrder());
        
        int sum = 0;
        int answer = 0;
        
        for(int count : counts){
            sum += count;
            answer++;
            
            if(sum >= k){
                break;
            }
        }
        
        return answer;
    }//solution end
}//class end