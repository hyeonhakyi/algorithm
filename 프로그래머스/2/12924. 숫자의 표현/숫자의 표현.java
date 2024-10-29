class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            int arr = 0;
            for(int j = i; j <= n; j++){
                arr += j;
                
                if(arr >= n){
                    if(arr == n){
                        answer += 1;
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}