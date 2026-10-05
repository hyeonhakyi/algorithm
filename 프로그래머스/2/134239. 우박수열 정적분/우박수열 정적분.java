import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        List<Long> list = new ArrayList<>();
        long num = k;
        list.add(num);
        while(num != 1){
            
            if(num % 2 != 0){
                num = (num * 3) + 1;
            }else{
                num /= 2;
            }
            list.add(num);
        }
        
        int n = list.size() - 1;
        
        double[] prefix = new double[n + 1];
        
        for(int i = 0; i < n; i++){
            double area = (list.get(i) + list.get(i + 1)) / 2.0;
            
            prefix[i + 1] = prefix[i] + area;
        }
        
        for(int i = 0; i < ranges.length; i++){
            int start = ranges[i][0];
            int end = n + ranges[i][1];
            
            if(start > end){
                answer[i] = -1.0;
            }else{
                answer[i] = prefix[end] - prefix[start];
            }
            
        }
        
        return answer;
    }//solution end
}//class end