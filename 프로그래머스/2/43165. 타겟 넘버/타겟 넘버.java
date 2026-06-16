import java.util.*;

class Solution {
    static int n,answer;
    static boolean[] visited;
    public int solution(int[] numbers, int target) {
        answer = 0;
        n = numbers.length;
        visited = new boolean[n];
        
        dfs(numbers,target,0,0);
        
        return answer;
    }//solution end
    
    private static void dfs(int[] numbers,int target,int idx,int sum){
        if(idx == n){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        dfs(numbers,target,idx + 1,sum + numbers[idx]);
        dfs(numbers,target,idx + 1,sum - numbers[idx]);
    }//dfs end
}//class end