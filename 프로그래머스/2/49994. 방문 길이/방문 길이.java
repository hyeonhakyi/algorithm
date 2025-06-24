import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        
        Set<String> set = new HashSet<>();
        
        int answer = 0;
        
        for(char s : dirs.toCharArray()){
            int nextX = x;
            int nextY = y;
            
            switch(s){
                case 'U':
                    nextX += 1;
                    break;
                case 'D':
                    nextX -= 1;
                    break;
                case 'R':
                    nextY += 1;
                    break;
                case 'L':
                    nextY -= 1;
                    break;
            }
            
            if(nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5){
                continue;
            }
            
            String path1 = x + "," + y + "," + nextX + "," + nextY;
            String path2 = nextX + "," + nextY + "," + x + "," + y;
            
            if(!set.contains(path1) && !set.contains(path2)){
                answer++;
                set.add(path1);
                set.add(path2);
            }
            
            x = nextX;
            y = nextY;
        }
        
        
        return answer;
    }
}