import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(String str : operations){
            String[] arr = str.split(" ");
            String s = arr[0];
            int num = Integer.parseInt(arr[1]);
            
            if(s.equals("I")){
                map.put(num,map.getOrDefault(num,0) + 1);
            }else{
                if(map.isEmpty()) continue;
                
                if(num == 1){
                    int key = map.lastKey();
                    int cnt = map.get(key);
                    if(cnt == 1) {
                        map.remove(key);
                    }else{
                        map.put(key,cnt-1);
                    }
                }else{
                    int key = map.firstKey();
                    int cnt = map.get(key);
                    if(cnt == 1){
                        map.remove(key);
                    }else{
                        map.put(key,cnt - 1);
                    }
                }
            }
        }
        if(map.isEmpty()){
            return new int[]{0,0};
        }
            
        return new int[]{map.lastKey(),map.firstKey()};
    }//solution end
}//class end