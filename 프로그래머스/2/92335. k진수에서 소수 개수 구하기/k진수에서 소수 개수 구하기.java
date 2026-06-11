import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String str = Integer.toString(n,k);
        
        String[] arr = str.split("0");
        
        
        for(String s : arr){
            if(s.length() == 0){
                continue;
            }
            
            long num = Long.parseLong(s);
            
            if(check(num)){
                answer++;
            }
        }
        
        return answer;
    }//solution end
    
    private static boolean check(Long num){
        if(num < 2) return false;
        
        for(long i = 2; i * i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }//check end
}//class end