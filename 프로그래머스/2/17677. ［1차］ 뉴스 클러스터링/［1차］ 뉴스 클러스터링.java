import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = makeMap(str1);
        Map<String, Integer> map2 = makeMap(str2);
        
        int intersection = 0;
        int union = 0;
        
        Set<String> keySet = new HashSet<>();
        
        keySet.addAll(map1.keySet());
        keySet.addAll(map2.keySet());
        
        for(String key : keySet){
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            
            intersection += Math.min(count1,count2);
            union += Math.max(count1,count2);
        }
        
        if(union == 0){
            return 65536;
        }
        
        return (int) ((double) intersection / union * 65536);
    }//solution end
    
    private static Map<String, Integer> makeMap(String str){
        Map<String,Integer> map = new HashMap<>();
        
        str = str.toUpperCase();
        
        for(int i = 0; i < str.length() - 1; i++){
            char first = str.charAt(i);
            char second = str.charAt(i + 1);
            
            if(check(first) && check(second)){
                String word = "" + first + second;
                map.put(word,map.getOrDefault(word,0) + 1);
            }
        }
        return map;
    }//makeMap end
    
    private static boolean check(char c){
        return c >= 'A' && c <= 'Z';
    }//check end
}//class end