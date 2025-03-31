import java.util.*;

class Solution {
    public int solution(String[] board) {
        int xCount = 0;
        int oCount = 0;
        
        for(String arr: board){
            for(char str: arr.toCharArray()){
                if(str == 'X') xCount++;
                if(str == 'O') oCount++;
            }
        }
        
        if(xCount > oCount || oCount - xCount > 1) return 0;
        
        boolean oWin = isWin(board, 'O');
        boolean xWin = isWin(board, 'X');
        
        if(oWin && xWin) return 0;
        if(oWin && oCount != xCount + 1) return 0;
        if(xWin && oCount != xCount) return 0;
        
        return 1;
    }
    
    static boolean isWin(String[] board,char str){
        for(int i = 0; i < 3; i++){
            if(board[i].charAt(0)== str &&
               board[i].charAt(1) == str &&
               board[i].charAt(2) == str){
                return true;
            }
        }
        
        for(int j = 0; j < 3; j++){
            if(board[0].charAt(j) == str &&
               board[1].charAt(j) == str &&
               board[2].charAt(j) == str){
            
                return true;
            }
        }
        
        if(board[0].charAt(0) == str &&
           board[1].charAt(1) == str &&
           board[2].charAt(2) == str){
            return true;
        }
        
        if(board[0].charAt(2) == str &&
           board[1].charAt(1) == str &&
           board[2].charAt(0) == str){
            return true;
        }
        
        return false;
    }//isWin end
}