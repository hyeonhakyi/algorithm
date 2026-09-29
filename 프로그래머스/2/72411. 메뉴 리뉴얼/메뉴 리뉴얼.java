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
                combination(arr,new StringBuilder(),map,target,0);
            }
            
            int maxCount = 0;
            for(int i : map.values()){
                if(i >= 2){
                    maxCount = Math.max(i,maxCount);
                }
            }
            
            for(String str : map.keySet()){
                if(map.get(str) == maxCount && maxCount >= 2){
                    answerList.add(str);
                }
            }
        }
        
        Collections.sort(answerList);
        
        return answerList.toArray(new String[0]);
    }//solution end
    
    private static void combination(char[] arr,StringBuilder sb,HashMap<String,Integer> map,int target,int start){
        if(sb.length() == target){
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0) + 1);
            
            return;
        }
        
        for(int i = start; i < arr.length; i++){
            sb.append(arr[i]);
            
            combination(arr,sb,map,target,i + 1);
            
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return;
    }//combination end
}//class end