import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 0;
        int y = 0;
        
        // 방문한 경로를 저장할 Set
        Set<String> visitedPaths = new HashSet<>();
        
        int answer = 0;
        
        for(char s : dirs.toCharArray()){
            int nextx = x;
            int nexty = y;
            
            switch(s){
                case 'U':
                    nexty += 1;
                    break;
                case 'D':
                    nexty -= 1;
                    break;
                case 'R':
                    nextx += 1;
                    break;
                case 'L':
                    nextx -= 1;
                    break;
            }
            
            if(nextx > 5 || nextx < -5 || nexty > 5 || nexty < -5){
                continue;
            }
            
            String path1 = x + "," + y + "," + nextx + "," + nexty;
            String path2 = nextx + "," + nexty + "," + x + "," + y;
            
            
            // 두 방향 중 하나로 저장 (이미 방문한 경로인지 확인)
            if(!visitedPaths.contains(path1) && !visitedPaths.contains(path2)) {
                answer++;
                visitedPaths.add(path1);
                visitedPaths.add(path2);
            }
            
            x = nextx;
            y = nexty;
        }       
        
        return answer;
    }
}