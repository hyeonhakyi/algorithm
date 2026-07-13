import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = find(arrayA);
        int gcdB = find(arrayB);
        
        int answerA = 0;
        int answerB = 0;
        
        if(check(gcdA,arrayB)){
            answerA = gcdA;
        }
        
        if(check(gcdB,arrayA)){
            answerB = gcdB;
        }
        
        return Math.max(answerA,answerB);
    }//solution end
    
    private static int find(int[] arr){
        int result = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            result = gcd(result,arr[i]);
        }
        
        return result;
    }//find end
    
    private static int gcd(int a,int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }//gcd end
    
    private static boolean check(int target,int[] arr){
        for(int i : arr){
            if(i % target == 0){
                return false;
            }
        }
        
        return true;
    }//check end
}//class end