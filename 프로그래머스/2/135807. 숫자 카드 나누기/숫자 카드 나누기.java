class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = getGCD(arrayA);
        int gcdB = getGCD(arrayB);
        int maxA = 0;
        int maxB = 0;
        
        if(isVaild(gcdA,arrayB)){
            maxA = gcdA;
        }else{
            maxA = 0;
        }
    
        if(isVaild(gcdB,arrayA)){
            maxB = gcdB;
        }else{
            maxB = 0;
        }
        
        return Math.max(maxB,maxA);
    }
    
    private int getGCD(int[] arr){
        int gcd = arr[0];
        for(int i = 1; i < arr.length; i++){
            gcd = gcd(gcd,arr[i]);
        }
        return gcd;
    }//getGCD end
    
    private int gcd(int a,int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }//gcd end
    
    private boolean isVaild(int num,int[] array){
        for(int i:array){
            if(i % num == 0){
                return false;
            }
        }
        return true;
    }//isValid end
}