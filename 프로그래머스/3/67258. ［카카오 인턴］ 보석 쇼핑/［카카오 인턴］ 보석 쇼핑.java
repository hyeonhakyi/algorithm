import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        Set<String> set = new HashSet<>();
        for(String s : gems){
            set.add(s);
        }
        int total = set.size();
        
        HashMap<String,Integer> map = new HashMap<>();
        int left = 0;
        int bestL = 0;
        int bestR = gems.length - 1;
        int bestLen = bestR - bestL + 1;
        
        for(int right = 0; right < gems.length; right++){
            map.put(gems[right],map.getOrDefault(gems[right],0) + 1);
            
            while(map.size() == total){
                int len = right - left + 1;
                
                if(len < bestLen){
                    bestLen = len;
                    bestL = left;
                    bestR = right;
                }
                
                String s = gems[left];
                int c = map.get(s) - 1;
                if(c == 0){
                    map.remove(s);   
                }else{
                    map.put(s,c);
                }
                left++;
            }
        }
        
        return new int[]{bestL + 1, bestR + 1};
    }//solution end
}//class end