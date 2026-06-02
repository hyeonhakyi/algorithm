import java.util.*;

class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers,target,0,0);
        
        return answer;
    }//solution end
    
    private static void dfs(int[] numbers,int target,int sum,int idx){
        if(idx == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        dfs(numbers,target,sum + numbers[idx],idx + 1);
        dfs(numbers,target,sum - numbers[idx],idx + 1);
    }//dfs end
}//class end