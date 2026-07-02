import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int len = nums.length / 2;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        
        if(len < map.size()){
            return len;
        }else{
            return map.size();
        }
    }//solution end
}//class end