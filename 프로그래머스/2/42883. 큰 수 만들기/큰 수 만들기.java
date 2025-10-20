import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        char[] arr = number.toCharArray();
        int len = number.length() - k;
        
        int start = 0;
        for(int i = 0; i < len; i++){
            char max = '0';
            for(int j = start; j <= i + k; j++){
                if(arr[j] > max){
                    max = arr[j];
                    start = j + 1;
                }
            }
            answer.append(max);
        }
        
        return answer.toString();
    }
}