class Solution {
    private static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers,target,0,0);
        return answer;
    }//main end
    
    public static void dfs(int[] numbers,int target,int count,int sum){
        if(count == numbers.length){
            if(target == sum){
                answer++;
            }
            return;
        }
        
        dfs(numbers,target,count+1,sum+numbers[count]);
        dfs(numbers,target,count+1,sum-numbers[count]);
    }//dfs end
}