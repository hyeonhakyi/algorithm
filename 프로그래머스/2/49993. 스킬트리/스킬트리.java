import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i = 0; i < skill_trees.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < skill_trees[i].length(); j++){
                char str = skill_trees[i].charAt(j);
                if(check(str,skill)){
                    sb.append(String.valueOf(str));
                }
            }
            
            if(skill.startsWith(sb.toString())){
                answer++;
            }
        }
        
        return answer;
    }//solution end
    
    private static boolean check(char str,String target){
        for(int i = 0; i < target.length(); i++){
            char tar = target.charAt(i);
            
            if(str == tar){
                return true;
            }
        }
        return false;
    }//check end
}//class end