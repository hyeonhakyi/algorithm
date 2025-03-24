class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 1;
        int right = 100_000;
        
        while(left <= right){
            int mid = (left+right) / 2;
            
            if(overCount(diffs,times,limit,mid)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean overCount(int[] diffs,int[] timeCur,long limit,int level){
        long timeSum = 0;
        for(int i = 0; i < diffs.length; i++){
            int diff = diffs[i];
            int time = timeCur[i];
            int timePre;
            
            if(i == 0){
                timePre = 0;
            }else{
                timePre = timeCur[i-1];
            }
            
            if(diff <= level){
                timeSum += time;
            }else{
                int cnt = diff - level;
                timeSum += (time + timePre) * (long) cnt + time;
            }
            if(limit < timeSum){
                return false;
            }
        }
        
        return true;
    }
}