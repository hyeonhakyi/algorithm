import java.util.*;

class Solution {
    static Set<Set<String>> result = new HashSet<>();
    static List<List<String>> candidates = new ArrayList<>();
    static Set<String> current = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        for(String ban:banned_id){
            List<String> mached = new ArrayList<>();
            for(String user : user_id){
                if(isMatch(user,ban)){
                    mached.add(user);
                }
            }
            candidates.add(mached);
        }
        
        dfs(0);
        
        return result.size();
    }
    
    public static void dfs(int depth){
        if(depth == candidates.size()){
            result.add(new HashSet<>(current));
            return;
        }
        
        for(String user : candidates.get(depth)){
            if(!current.contains(user)){
                current.add(user);
                dfs(depth + 1);
                current.remove(user);
            }
        }
    }//dfs end
    
    public boolean isMatch(String user, String ban){
        if(user.length() != ban.length()){
            return false;
        }
        
        for(int i = 0; i < user.length(); i++){
            if(ban.charAt(i) == '*') continue;
            if(user.charAt(i) != ban.charAt(i)) return false;
        }
        
        return true;
    }//isMatch end
}