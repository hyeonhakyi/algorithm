import java.util.*;

class Solution {
    static int[] arrWeak;
    static boolean[] visited;
    static int[] personDist;
    static int answer;
    static int weakLen;
    public int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;
        weakLen = weak.length;
        arrWeak = new int[weakLen * 2];
        personDist = new int[dist.length];
        visited = new boolean[dist.length];
        
        for(int i = 0; i < weakLen; i++){
            arrWeak[i] = weak[i];
            arrWeak[i + weakLen] = weak[i] + n;
        }
        
        permutation(dist,0);
        
        if(answer == Integer.MAX_VALUE){
            return -1;
        }else{
            return answer;
        }
    }//solution end
    
    private static void permutation(int[] person,int depth){
        if(depth == person.length){
            check();
            return;
        }
        
        for(int i = 0; i < person.length; i++){
            if(visited[i]){
                continue;
            }
            
            visited[i] = true;
            
            personDist[depth] = person[i];
            permutation(person,depth + 1);
            
            visited[i] = false;
        }
    }//permutation end
    
    private static void check(){
        for(int start = 0; start < weakLen; start++){
            int friendsCount = 1;
            int coverEnd = arrWeak[start] + personDist[friendsCount - 1];
            
            for(int i = start; i < start + weakLen; i++){
                int nextWeak = arrWeak[i];
                
                if(nextWeak > coverEnd){
                    friendsCount++;
                    
                    if(friendsCount > personDist.length){
                        break;
                    }
                
                    coverEnd = nextWeak + personDist[friendsCount - 1];
                }
            }
            
            if(friendsCount <= personDist.length){
                answer = Math.min(friendsCount,answer);
            }
        }
        return;
    }//check end
}//class end