import java.util.*;

class Solution {
    static char[] arr;
    static int maxLen;
    static int answer;
    static Set<Integer> set;
    static boolean[] visited;
    public int solution(String numbers) {
        maxLen = numbers.length();
        arr = numbers.toCharArray();
        visited = new boolean[maxLen];
        set = new HashSet<>();
        
        dfs(new StringBuilder());
        
        return set.size();
    }//solution end
    private static void dfs(StringBuilder sb){
        if(sb.length() > 0){
            int num = Integer.parseInt(sb.toString());
            
            if(check(num)){
                set.add(num);
            }
        }
        
        if(sb.length() == maxLen){
            return;
        }
        
        for(int i = 0; i < maxLen; i++){
            if(visited[i]){
                continue;
            }
            
            visited[i] = true;
            sb.append(arr[i]);
            
            dfs(sb);
            
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }//dfs end
    
    private static boolean check(int num){
        if(num < 2){
            return false;
        }
        
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }//check end
}//class end