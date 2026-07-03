import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for(String str : phone_book){
            set.add(str);
        }
        
        for(String str : phone_book){
            for(int i = 0; i < str.length(); i++){
                String prifix = str.substring(0,i);
                
                if(set.contains(prifix)){
                    return false;
                }
            }
        }
        
        return true;
    }//solution end
}//class end