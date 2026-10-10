import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int pickCount = picks[0] + picks[1] + picks[2];
        
        int limit = Math.min(minerals.length,pickCount * 5);
        
        List<int[]> groups = new ArrayList<>();
        
        for(int i = 0; i < limit; i += 5){
            int[] count = new int[3];
            for(int j = i; j < i + 5 && j < limit; j++){
                if(minerals[j].equals("diamond")){
                    count[0]++;
                }else if(minerals[j].equals("iron")){
                    count[1]++;
                }else{
                    count[2]++;
                }
            }
            
            groups.add(count);
        }
        
        groups.sort((a,b) ->{
           if(a[0] != b[0]){
               return Integer.compare(b[0],a[0]);
           }
            return Integer.compare(b[1],a[1]);
        });
        
        int idx = 0;
        for(int i = 0; i < 3; i++){
            while(picks[i] > 0 && idx < groups.size()){
                int[] group = groups.get(idx);
                
                if(i == 0){
                    answer += group[0] + group[1] + group[2];
                }else if(i == 1){
                    answer += (group[0] * 5) + group[1] + group[2];
                }else{
                    answer += (group[0] * 25) + (group[1] * 5) + group[2];
                }
                
                picks[i]--;
                idx++;
            }
        }
        
        return answer;
    }//solution end
}//class end