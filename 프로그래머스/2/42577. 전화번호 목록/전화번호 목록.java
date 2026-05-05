import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(String str : phone_book){
            set.add(str);
        }
        
        for(String str : phone_book){
            for(int i = 1; i < str.length(); i++){
                String prefix = str.substring(0,i);
                
                if(set.contains(prefix)){
                    return false;
                }
            }
        }
        
        return true;
    }//main end
}//class end