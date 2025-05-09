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
        
        for(int[] score : scores){
            int a = score[0];
            int b = score[1];
            
            if(a > wan[0] && b > wan[1]){
                return -1;
            }
            
            if(b >= maxB){
                maxB = Math.max(maxB, b);
                list.add(a + b);
            }
        }
        
        list.sort(Collections.reverseOrder());
        
        int rank = 1;
        for(int sum : list){
            if(sum > wanSum){
                rank++;
            }else if(sum == wanSum){
                return rank;
            }
        }
        
        return rank;
    }
}