import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        
        for(int j = height - 2; j >= 0; j--){
            for(int i = 0; i < triangle[j].length; i++){
                triangle[j][i] += Math.max(triangle[j+1][i],triangle[j+1][i+1]);
            }
        }
        
        return triangle[0][0];
    }
}