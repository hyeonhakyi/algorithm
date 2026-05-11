import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] arr = new int[n * 2];
        
        for(int i = 0; i < n; i++){
            arr[i] = elements[i];
            arr[i + n] = elements[i];
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int len = 1; len <= n; len++){
            for(int start = 0; start < n; start++){
                int sum = 0;
                
                for(int k = 0; k < len; k++){
                    sum += arr[start + k];
                }
                
                set.add(sum);
            }
        }
        
        return set.size();
    }//solution end
}//class end