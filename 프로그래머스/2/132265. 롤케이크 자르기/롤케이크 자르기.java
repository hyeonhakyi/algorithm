import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        
        Set<Integer> fir = new HashSet<>();
        HashMap<Integer,Integer> sec = new HashMap<>();
            
        for(int i = 0; i < n; i++){
            sec.put(topping[i],sec.getOrDefault(topping[i],0) + 1);
        }
        
        for(int i = 0; i < n - 1; i++){
            int num = topping[i];
            
            fir.add(num);
            
            sec.put(num,sec.get(num) - 1);
            
            if(sec.get(num) == 0){
                sec.remove(num);
            }
            
            if(fir.size() == sec.size()){
                answer++;
            }
        }
        
        return answer;
    }//solution end
}//class end