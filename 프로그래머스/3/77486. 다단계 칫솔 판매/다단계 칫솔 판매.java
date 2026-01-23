import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        Map<String,Integer> indexMap = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            indexMap.put(enroll[i],i);
        }
        
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            if(referral[i].equals("-")){
                parent[i] = -1;
            }else{
                parent[i] = indexMap.get(referral[i]);
            }
        }
        
        int[] profit = new int[n];
        
        for(int i = 0; i < seller.length; i++){
            int cur = indexMap.get(seller[i]);
            int money = amount[i] * 100;
            
            while(cur != -1 && money > 0){
                int give = money / 10;
                int keep = money - give;
            
                profit[cur] += keep;
                cur = parent[cur];
                money = give;
            }
        }
        
        return profit;
    }//main end
}//class end