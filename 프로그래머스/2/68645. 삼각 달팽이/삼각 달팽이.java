import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int[] answer = new int[(n*(n+1))/2];
        int x = -1;
        int y = 0;
        int num = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0){
                    x++;
                }else if(i % 3 == 1){
                    y++;
                }else if(i % 3 == 2){
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }
        
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0){
                    break;
                }else{
                    answer[idx++] = arr[i][j];
                }
            }
        }
        
        
        return answer;
    }
}