import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {        
        Map<String,Integer> map = new HashMap<>();
        int[] parents = new int[referral.length];
        int[] answer = new int[enroll.length];
        
        for(int i = 0; i < enroll.length; i++){
            map.put(enroll[i],i);
        }
        
        for(int i = 0; i < referral.length; i++){
            if(referral[i].equals("-")){
                parents[i] = -1;
            }else{
                parents[i] = map.get(referral[i]);
            }
        }
        
        for(int i = 0; i < seller.length; i++){
            int now = map.get(seller[i]);
            int money = amount[i] * 100;
            
            while(now != -1 && money > 0){
                int give = money / 10;
                int keep = money - give;
                
                answer[now] += keep;
                now = parents[now];
                money = give;
            }
        }
        
        return answer;
    }//solution end
}//class end