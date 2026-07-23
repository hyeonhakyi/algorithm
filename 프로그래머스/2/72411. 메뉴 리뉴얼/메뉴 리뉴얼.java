import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        
        for(int target : course){
            HashMap<String,Integer> map = new HashMap<>();
            
            for(String order : orders){
                if(order.length() < target){
                    continue;
                }
                
                char[] arr = order.toCharArray();
                
                Arrays.sort(arr);
                
                combination(arr,0,target,new StringBuilder(),map);
            }
            
            int maxCount = 0;
        
            for(int count : map.values()){
                if(count >= 2){
                    maxCount = Math.max(maxCount,count);
                }
            }
        
            for(String menu : map.keySet()){
                if(map.get(menu) == maxCount && maxCount >= 2){
                    answerList.add(menu);
                }
            }   
        }
        
        Collections.sort(answerList);
        
        return answerList.toArray(new String[0]);
    }//solution end
    
    private static void combination(char[] arr,int start,int target,StringBuilder sb,HashMap<String,Integer> map){
        if(sb.length() == target){
            String menu = sb.toString();
            
            map.put(menu,map.getOrDefault(menu, 0) + 1);
            
            return;
        }
        
        for(int i = start; i < arr.length; i++){
            sb.append(arr[i]);
            
            combination(arr,i + 1, target,sb,map);
            
            sb.deleteCharAt(sb.length() - 1);
        }
    }//combination end
}//class end