import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        
        if(n < 2){
            return 0;
        }
        
        int[] count = new int[n];
        
        for(int num : a){
            count[num]++;
        }
        
        int maxCount = 0;
        
        for(int x = 0; x < n; x++){
            if(count[x] <= maxCount){
                continue;
            }
            
            int pairCount = 0;
            
            for(int i = 0; i < n - 1; i++){
                if(a[i] == a[i + 1]){
                    continue;
                }
                
                if(a[i] == x || a[i + 1] == x){
                    pairCount++;
                    i++;
                }
            }
            
            maxCount = Math.max(maxCount,pairCount);
        }
        
        return maxCount * 2;
    }//solution end
}//class end