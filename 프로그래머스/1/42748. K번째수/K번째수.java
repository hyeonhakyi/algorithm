import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int count = 0;
        for(int i = 0; i < commands.length; i++){
            int s = commands[i][0] - 1;
            int e = commands[i][1] - 1;
            int t = commands[i][2] - 1;
            
            int[] arr = new int[e - s + 1];
            int idx = 0;
            for(int j = s; j <= e; j++){
                arr[idx++] = array[j];
            }
            
            Arrays.sort(arr);
            
            answer[count++] = arr[t];
        }
        
        return answer;
    }//solution end
}//class end