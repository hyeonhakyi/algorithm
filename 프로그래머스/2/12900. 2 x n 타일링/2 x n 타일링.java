class Solution {
    public int solution(int n) {
        int answer = 0;
        int []arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        
        for(int i=3;i<=n;i++){
            int temp = arr[i-1] + arr[i-2];
            arr[i] = temp%1000000007;
        }
        
        return arr[n];
    }
}