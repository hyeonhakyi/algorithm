import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int pick = picks[0] + picks[1] + picks[2];
        int total = Math.min(minerals.length,pick * 5);
        
        List<int[]> list = new ArrayList<>();
        int d = 0;
        int i = 0;
        int s = 0;
        int cnt = 0;
        for(int idx = 0; idx < total; idx++){
            String m = minerals[idx];
            
            if("diamond".equals(m)){
                d++;
            }else if("iron".equals(m)){
                i++;
            }else{
                s++;
            }
            cnt++;
            
            if(cnt == 5){
                list.add(new int[]{d,i,s});
                d = i = s = 0;
                cnt = 0;
            }
        }
        
        if(cnt > 0){
            list.add(new int[]{d,s,i});
        }
        
        list.sort((a,b) -> {
            int A = a[0] * 25 + a[1] * 5 + a[2];
            int B = b[0] * 25 + b[1] * 5 + b[2];
            return Integer.compare(B,A);
        });
        
            
        int dia = picks[0];
        int iro = picks[1];
        int sto = picks[2];
        
        int answer = 0;
        for(int[] a : list){
            if(dia > 0){
                dia--;
                answer += a[0] + a[1] + a[2];
            }else if(iro > 0){
                iro--;
                answer += a[0]*5 + a[1] + a[2];
            }else if(sto > 0){
                sto--;
                answer += a[0]*25 + a[1]*5 + a[2];
            }
        }
        
        return answer;
    }
}