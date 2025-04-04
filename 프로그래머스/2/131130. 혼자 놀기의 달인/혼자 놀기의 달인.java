import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visited = new boolean[cards.length];
        List<Integer> list = new LinkedList<>();
        
        for(int i = 0; i < cards.length; i++){
            if(!visited[i]){
                int count = 0;
                int current = i;
            
                while(!visited[current]){
                    visited[current] = true;
                    current = cards[current] - 1;
                    count++;
                }
            
                list.add(count);    
            }
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        if(list.size() < 2){
            return 0;
        }
        
        return list.get(0) * list.get(1);
    }
}