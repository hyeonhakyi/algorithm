import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemKinds = new HashSet<>(Arrays.asList(gems));
        Map<String,Integer> gemMap = new HashMap<>();
        
        int totalKinds = gemKinds.size();
        int left = 0;
        int right = 0;
        int minLen  = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while(right < gems.length){
            gemMap.put(gems[right], gemMap.getOrDefault(gems[right], 0) + 1);
            right++;
            
            while(gemMap.size() == totalKinds){
                if(right - left < minLen ){
                    minLen  = right - left;
                    answer[0] = left + 1;
                    answer[1] = right;
                }
                
                gemMap.put(gems[left], gemMap.get(gems[left]) - 1);
                if(gemMap.get(gems[left]) == 0){
                    gemMap.remove(gems[left]);
                }
                left++;
            }
        }
        
        return answer;
    }
}