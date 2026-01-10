import java.util.*;

class Solution {
    static Set<Set<String>> result = new HashSet<>();
    static boolean[] visited;
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        dfs(0,user_id,banned_id,new HashSet<>());
        return result.size();
    }//main end
    
    static void dfs(int idx,String[] user,String[] banned,Set<String> set){
        if(idx == banned.length){
            result.add(new HashSet<>(set));
            return;
        }
        
        for(int i = 0; i < user.length; i++){
            if(visited[i]) continue;
            
            if(isMathch(user[i],banned[idx])){
                visited[i] = true;
                set.add(user[i]);
                
                dfs(idx + 1,user,banned,set);
                
                visited[i] = false;
                set.remove(user[i]);
            }
        }
    }//dfs end
    
    static boolean isMathch(String user,String banned){
        if(user.length() != banned.length()){
            return false;
        }
        
        for(int i = 0; i < user.length(); i++){
            if(banned.charAt(i) == '*') continue;
            if(user.charAt(i) != banned.charAt(i)) return false;
        }
        
        return true;
    }//isMAthch end
}//class end