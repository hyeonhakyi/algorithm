import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2,s.length() - 2);
        
        String[] arr = s.split("\\},\\{");
        
        Arrays.sort(arr,(a,b) ->{
           return Integer.compare(a.length(),b.length()); 
        });
        
        Set<Integer> set = new HashSet();
        
        List<Integer> list = new ArrayList<>();
        
        for(String str : arr){
            String[] nums = str.split(",");
            
            for(String num : nums){
                int value = Integer.parseInt(num);
                
                if(!set.contains(value)){
                    set.add(value);
                    list.add(value);
                }   
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }//solution end
}//class end