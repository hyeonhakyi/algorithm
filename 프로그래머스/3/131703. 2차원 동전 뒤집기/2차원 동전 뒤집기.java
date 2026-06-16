import java.util.*;

class Solution {
    static int n,m,answer;
    static int[][] arr;
    static int[][] targetArr;
    public int solution(int[][] beginning, int[][] target) {
        n = beginning.length;
        m = beginning[0].length;
        arr = new int[n][m];
        targetArr = new int[n][m];
        
        for(int i = 0; i < n; i++){
            arr[i] = beginning[i].clone();
        }
        
        for(int i = 0; i < n; i++){
            targetArr[i] = target[i].clone();
        }
        
        answer = Integer.MAX_VALUE;
        
        dfs(0,0);
        
        if(answer == Integer.MAX_VALUE){
            return -1;
        }
        
        return answer;
    }//solution end
    
    private static void dfs(int row,int count){
        if(row == n){
            int[][] temp = copy(arr);
            int totalCount = count;
            
            for(int col = 0; col < m; col++){
                if(temp[0][col] != targetArr[0][col]){
                    changeCol(temp,col);
                    totalCount++;
                }
            }
            
             if (check(temp)) {
                answer = Math.min(answer, totalCount);
            }

            return;
        }
        
        dfs(row + 1,count);
        
        changeRow(arr,row);
        dfs(row + 1, count + 1);
        
        changeRow(arr,row);
    }//dfs end
    
    private static int[][] copy(int[][] arr){
        int[][] temp = new int[n][m];
        
        for(int i = 0; i < n; i++){
            temp[i] = arr[i].clone();
        }
        
        return temp;
    }//copy end
    
    private static void changeCol(int[][] board, int col){
        for(int i = 0; i < n; i++){
            board[i][col] = 1 - board[i][col];
        }
    }//changeCol end

    private static void changeRow(int[][] board, int row){
        for(int i = 0; i < m; i++){
            board[row][i] = 1 - board[row][i];
        }
    }//changeRow end
    
    private static boolean check(int[][] temp){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(temp[i][j] != targetArr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }//check end
}//class end