import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int left = 0;
        int right = people.length - 1;
        Arrays.sort(people);
        
        while(left <= right){
            int sum = people[left] + people[right];
            
            if(sum > limit){
                answer++;
                right--;
            }else{
                left++;
                right--;
                answer++;
            }
        }
        
        return answer;
    }//solution end
}//class end