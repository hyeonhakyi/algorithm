import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            String bin = Long.toBinaryString(numbers[i]);
            
            int len = bin.length();
            int fullLen = 1;
        
            while(fullLen < len){
                fullLen = fullLen * 2 + 1;
            }
            
            String arr = "0".repeat(fullLen - len) + bin;
            
            if(dfs(arr,0,fullLen - 1)){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }
        
        return answer;
    }//main end
    
    private static boolean dfs(String arr,int left,int right){
        if(left == right) return true;
        
        int mid = (left + right) / 2;
        char root = arr.charAt(mid);
        
        int leftMid = (left + mid - 1) / 2;
        int rightMid = (right + mid + 1) / 2;

        if(root == '0'){
            if(arr.charAt(leftMid) == '1' || arr.charAt(rightMid) == '1') return false;
        }
        
        return dfs(arr,left,mid - 1) && dfs(arr,mid + 1,right);
    }//dfs end
}//class end