import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data,(a,b) -> {
            if(a[col - 1] == b[col - 1]){
                return Integer.compare(b[0],a[0]);
            }
            return Integer.compare(a[col - 1],b[col - 1]);
        });
        
        for(int i = row_begin; i <= row_end; i++){
            int sum = 0;
            for (int j = 0; j < data[i - 1].length; j++) {
                sum += data[i - 1][j] % i;
            }
            
            answer ^= sum;
        }
        
        
        return answer;
    }//solution end
}//class end