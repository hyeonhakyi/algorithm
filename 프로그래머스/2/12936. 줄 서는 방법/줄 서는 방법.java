import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++){
            fact[i] = fact[i - 1] * i;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        
        k--;
        for(int i = 0; i < n; i++){
            long block = fact[n - 1 - i];
            int idx = (int)(k / block);
            answer[i] = list.remove(idx);
            k %= block;
        }
        
        return answer;
    }
}