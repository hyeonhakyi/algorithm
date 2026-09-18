import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        int[] arr = new int[n * 2];
        
        for(int i = 0; i < n; i++){
            arr[i] = elements[i];
            arr[i + n] = elements[i];
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int start = 0; start < n; start++){
            int sum = 0;
            for(int length = 0; length < n; length++){
                int idx = (start + length) % n;
                
                sum += arr[idx];
                
                set.add(sum);
            }
        }
        
        return set.size();
    }//solution end
}//class end