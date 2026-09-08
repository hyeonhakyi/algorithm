import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0) + 1);
        }
        
        List<Integer> counts = new LinkedList(map.values());

        counts.sort(Collections.reverseOrder());
        
        int sum = 0;
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