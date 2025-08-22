import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wan = scores[0];
        int wanSum = wan[0] + wan[1];
        
        Arrays.sort(scores, (o1,o2) -> {
            if(o1[0] != o2[0]){
                return o2[0] - o1[0];
            }else{
                return o1[1] - o2[1];
            }
        });
        
        int maxB = 0;
        List<Integer> list = new ArrayList<>();
        for(int[] s : scores){
            int a = s[0];
            int b = s[1];
            
            if(wan[0] < a && wan[1] < b){
                return -1;
            }
            
            if(b >= maxB){
                maxB = Math.max(b,maxB);
                list.add(a + b);
            }
        }
        
        list.sort(Collections.reverseOrder());
        
        int rank = 1;
        for(int r : list){
            if(r > wanSum){
                rank++;
            }else if(r == wanSum){
                return rank;
            }
        }
        
        return rank;
    }
}