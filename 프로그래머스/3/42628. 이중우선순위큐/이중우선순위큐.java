import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        
        for(int i = 0; i < operations.length; i++){
            String[] s = operations[i].split(" ");
            
            if(maxQ.isEmpty() && s[0].equals("D")){
                continue;
            }
            
            if(s[0].equals("I")){
                maxQ.offer(Integer.parseInt(s[1]));
                minQ.offer(Integer.parseInt(s[1]));
            } else if(s[0].equals("D") && s[1].equals("-1")){
                int min = minQ.poll();
                maxQ.remove(min);
            } else if(s[0].equals("D") && s[1].equals("1")){
                int max = maxQ.poll();
                minQ.remove(max);
            }
        }
        
        if(maxQ.isEmpty()) return new int[] {0,0};
        return new int[] {maxQ.poll(),minQ.poll()};
    }
}