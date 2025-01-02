import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] arr = s.split("-");
        
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        
        List<Integer> list = new ArrayList<>();
        
        for (String st : arr){
            String[] check = st.split(",");
            
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