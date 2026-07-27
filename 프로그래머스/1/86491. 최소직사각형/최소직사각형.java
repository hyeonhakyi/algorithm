import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxRow = 0;
        int maxCor = 0;
        
        for(int i = 0; i < sizes.length; i++){
            int nowRow = Math.max(sizes[i][0],sizes[i][1]);
            int nowCor = Math.min(sizes[i][0],sizes[i][1]);
            
            maxRow = Math.max(nowRow,maxRow);
            maxCor = Math.max(nowCor,maxCor);
        }
        return maxRow * maxCor;
    }//solution end
}//class end