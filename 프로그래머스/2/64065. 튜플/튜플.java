import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        s = s.substring(2,s.length() - 2).replace("},{","-");
        String[] str = s.split("-");
        
        Arrays.sort(str, Comparator.comparingInt(String::length));
        
        List<Integer> list = new ArrayList<>();
        
        for(String arr : str){
            String[] check = arr.split(",");
            
            for(int i = 0; i < check.length; i++){
                int num = Integer.parseInt(check[i]);
                
                if(!list.contains(num)){
                    list.add(num);
                }
            }
        }
        
        return list;
    }
}