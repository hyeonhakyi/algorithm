import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            long num = numbers[i];
            
            if(num % 2 == 0){
                answer[i] = num + 1;
            }else{
                String to2 = Long.toBinaryString(num);
                
                if(to2.contains("0")){
                    int idx = to2.lastIndexOf("0");
                    to2 = to2.substring(0, idx) + "10" + to2.substring(idx + 2);
                }else{
                    to2 = "10" + to2.substring(1);
                }
                answer[i] = Long.parseLong(to2,2);
            }
        }
        
        return answer;
    }
}