class Solution {
    static int n;
    static int answer = 0;
    static int[] arr;
    public int solution(int n) {
        this.n = n;
        arr = new int[n];
        
        dfs(0);
        return answer;
    }
    
    static void dfs(int row){
        if(row == n){
            answer++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            arr[row] = i;
            
            if(check(row)){
                dfs(row + 1);
            }
        }
    }//dfs end
    
    static boolean check(int col){
        for(int i = 0; i < col; i++){
            if(arr[col] == arr[i]){
                return false;
            }
            
            if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])){
                return false;
            }
        }
        return true;
    }//check end
}