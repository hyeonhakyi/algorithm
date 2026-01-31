import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wan = scores[0];
        int wanSum = wan[0] + wan[1];
        
        Arrays.sort(scores, (a,b) ->{
            if(a[0] != b[0]){
                return b[0] - a[0];
            }else{
                return a[1] - b[1];
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
                list.add(a + b);
                maxB = b;
            }
        }
        
        int answer = 1;
        for(int i : list){
            if(i > wanSum){
                answer++;
            }
        }        
        return answer;
    }
}