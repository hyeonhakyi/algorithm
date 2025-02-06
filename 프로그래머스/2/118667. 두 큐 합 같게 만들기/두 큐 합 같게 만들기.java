import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0, sum2 = 0;
        int n = queue1.length;
        
        for(int num1 : queue1){
            q1.add(num1);
            sum1 += num1;
        }
        
        for(int num2 : queue2){
            q2.add(num2);
            sum2 += num2;
        }
        
        long totalSum = sum1 + sum2;
        
        if(totalSum % 2 != 0){
            return -1;
        }
        
        long target = totalSum / 2;
        int maxOperation = n * 3;
        int count = 0;
        
        while(count <= maxOperation){
            if(sum1 == target){
                return count;
            }else if(sum1 > target){
                if(!q1.isEmpty()){
                    int num = q1.poll();
                    sum1 -= num;
                    q2.add(num);   
                }
            }else{
                if(!q2.isEmpty()){
                    int num = q2.poll();
                    sum1 += num;
                    q1.add(num);   
                }
            }    
            count++;
        }
        
        return -1;
    }
}