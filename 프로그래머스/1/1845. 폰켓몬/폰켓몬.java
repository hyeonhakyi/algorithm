import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length/2;
        
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        
        int size = set.size();
        
        if(size >= max){
            answer = max;
        }else{
            answer = size;
        }
        
        return answer;
    }
}