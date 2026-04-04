import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wanFirst = scores[0][0];
        int wanSecond = scores[0][1];
        int wanSum = wanFirst + wanSecond;
        
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        
        int maxSecond = Integer.MIN_VALUE;
        int answer = 1;
        for(int[] score : scores){
            int fir = score[0];
            int sec = score[1];
            
            if(sec < maxSecond){
                if(fir == wanFirst && sec == wanSecond){
                    return -1;
                }
                continue;
            }
            
            maxSecond = Math.max(maxSecond,sec);
            
            int sum = fir + sec;
            if(wanSum < sum){
                answer++;
            }
        }    
        
        return answer;
    }//solution end
}//class end