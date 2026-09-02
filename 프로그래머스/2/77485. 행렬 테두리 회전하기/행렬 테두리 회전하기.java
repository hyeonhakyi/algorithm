import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] arr = new int[rows][columns];
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = i * columns + j + 1;
            }
        }
       
        int idx = 0;
        for(int[] que : queries){
            int x1 = que[0] - 1;
            int y1 = que[1] - 1;
            int x2 = que[2] - 1;
            int y2 = que[3] - 1;
            
            int temp = arr[x1][y1];
            int min = temp;
            
            //우
            for(int i = y1 + 1; i <= y2; i++){
                int next = arr[x1][i];
                
                arr[x1][i] = temp;
                
                temp = next;
                min = Math.min(min,next);
            }
            
            //하
            for(int i = x1 + 1; i <= x2; i++){
                int next = arr[i][y2];
                
                arr[i][y2] = temp;
                
                temp = next;
                min = Math.min(min,next);
            }
            
            //좌
            for(int i = y2 - 1; i >= y1; i--){
                int next = arr[x2][i];
                
                arr[x2][i] = temp;
                
                temp = next;
                min = Math.min(min,next);
            }
            
            //상
            for(int i = x2 - 1; i >= x1; i--){
                int next = arr[i][y1];
                
                arr[i][y1] = temp;
                
                temp = next;
                min = Math.min(min,next);
            }
            
            answer[idx++] = min;
        }
        
        return answer;
    }//solution end
}//class end