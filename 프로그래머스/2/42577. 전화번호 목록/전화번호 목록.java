import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        
        for(String str : phone_book){
            set.add(str);
        }
        
        for(int i = 0; i < phone_book.length; i++){
            String str = phone_book[i];
            for(int j = 0; j < str.length(); j++){
                String arr = str.substring(0,j);
                
                if(set.contains(arr)){
                    return false;
                }
            }
        }
        
        return answer;
    }//solution end
}//class end