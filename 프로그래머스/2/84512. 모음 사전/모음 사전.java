import java.util.*;

class Solution {
    static String[] arr = {"A","E","I","O","U"};
    static int answer,count;
    public int solution(String word) {
        answer = 0;
        count = 0;
        dfs(word,new StringBuilder());
        
        return answer;
    }//solution end
    
    private static void dfs(String word,StringBuilder sb){
        if(answer != 0){
            return;
        }
        
        if(sb.length() > 0){
            count++;
            
            if(word.equals(sb.toString())){
                answer = count;
                return;
            }
        }
        
        if(sb.length() == 5){
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);

            dfs(word, sb);

            sb.deleteCharAt(sb.length() - 1);
        }
    }//dfs end
}//class end