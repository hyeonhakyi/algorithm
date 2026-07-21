import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
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
                    int key = map.firstKey();
                    int cnt = map.get(key);
                    if(cnt == 1){
                        map.remove(key);
                    }else{
                        map.put(key,cnt - 1);
                    }
                }else{
                    int key = map.lastKey();
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
        }else{
            return new int[]{map.lastKey(),map.firstKey()};
        }
        
    }//solution end
}//class end