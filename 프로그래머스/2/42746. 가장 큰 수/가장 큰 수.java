import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        String[] num = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            num[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(num, (s1,s2) -> (s2+s1).compareTo(s1+s2));
        
        if(num[0].equals("0")){
            return "0";
        }
        
        for(String s : num){
            answer.append(s);
        }
        
        return answer.toString();
    }
}