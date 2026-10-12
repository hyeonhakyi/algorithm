import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(int i = 0; i < operations.length; i++){
            String[] arr = operations[i].split(" ");
            String type = arr[0];
            int num = Integer.parseInt(arr[1]);
            
            if(type.equals("I")){
                map.put(num,map.getOrDefault(num,0) + 1);
            }else{
                if(map.isEmpty()) continue;
                
                if(num == -1){
                    int first = map.firstKey();
                    int cnt = map.get(first);
                    
                    if(cnt == 1){
                        map.remove(first);
                    }else{
                        map.put(first,cnt - 1);
                    }
                }else{
                    int last = map.lastKey();
                    int cnt = map.get(last);
                    
                    if(cnt == 1){
                        map.remove(last);
                    }else{
                        map.put(last,cnt - 1);
                    }
                }
            }
        }
        
        if(map.isEmpty()){
            return new int[]{0,0};
        }else{
            return new int[]{map.lastKey(),map.firstKey()};
        }
    }//solution end
}//class end