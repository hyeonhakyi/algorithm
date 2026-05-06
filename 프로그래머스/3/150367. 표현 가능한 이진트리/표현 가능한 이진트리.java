import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            String binary = Long.toBinaryString(numbers[i]);
            
            String fullBinary = makeFullBinary(binary);
            
            if(check(fullBinary,0,fullBinary.length() - 1,true)){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }
        
        return answer;
    }//solution end
    
    private static String makeFullBinary(String binary){
        int len = binary.length();
        int fullLen = 1;
        while(fullLen < len){
            fullLen = fullLen * 2 + 1;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < fullLen - len; i++){
            sb.append("0");
        }
        
        sb.append(binary);
        
        return sb.toString();
    }//makeFullBinary end
    
    private static boolean check(String binary,int left,int right,boolean prev){
        if (left > right) return true;
        
        int mid = (left + right) / 2;
        char root = binary.charAt(mid);
        
        if(!prev && root == '1'){
            return false;
        }
        boolean currentRoot = false;
        if(root == '1'){
            currentRoot = true;
        }
        
        return check(binary, left, mid - 1, currentRoot) && check(binary, mid + 1, right, currentRoot);
    }//check end
}//class end