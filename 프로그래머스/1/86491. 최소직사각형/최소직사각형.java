import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int MaxWidth = 0;
        int MaxHeight = 0;
        for(int i = 0; i < sizes.length; i++){
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);
            
            MaxWidth = Math.max(MaxWidth, width);
            MaxHeight = Math.max(MaxHeight, height);
        }
        return MaxWidth * MaxHeight;
    }
}