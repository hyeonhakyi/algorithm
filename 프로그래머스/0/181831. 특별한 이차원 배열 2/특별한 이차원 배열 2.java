class Solution {
    public int solution(int[][] arr) {
        int num = 0;
        for(int i=0; i <arr.length; i++){
            for(int j=0; j <arr[i].length; j++){
                if(arr[i][j]!=arr[j][i]){
                    num =  0;
                    return num;
                }
            }
        }
        num = 1;
        
        return num;
    }
}