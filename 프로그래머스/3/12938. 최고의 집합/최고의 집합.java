class Solution {
    public int[] solution(int n, int s) {
        if(s < n){
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        
        int base = s/n;
        int remainder = s%n;
        
        for(int i = 0; i < n; i++){
            answer[i] = base;
        }
        
        for(int i = n - 1; i >= n - remainder; i--){
            answer[i]++;
        }
        
        return answer;
    }
}