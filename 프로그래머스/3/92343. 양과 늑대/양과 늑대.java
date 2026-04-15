import java.util.*;

class Solution {
    static List<Integer>[] list;
    static int[] infoArr;
    static int n,answer;
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        n = info.length;
        infoArr = info;
        
        list = new ArrayList[n];
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }
            
        for(int[] i : edges){
            int s = i[0];
            int e = i[1];
            
            list[s].add(e);
        }
        
        List<Integer> nextNode = new ArrayList<>();
        nextNode.add(0);
        dfs(0,0,nextNode);
        
        return answer;
    }//solution end
    
    private static void dfs(int sheep,int wolf,List<Integer> nextNode){
        answer = Math.max(answer,sheep);
        
        for(int i = 0; i < nextNode.size(); i++){
            int current = nextNode.get(i);
            
            int nextSheep = sheep;
            int nextWolf = wolf;
            
            if(infoArr[current] == 0){
                nextSheep++;
            }else{
                nextWolf++;
            }
            
            if(nextWolf >= nextSheep) continue;
            
            List<Integer> next = new ArrayList<>(nextNode);
            
            next.remove(i);
            
            for(int nextI : list[current]){
                next.add(nextI);
            }
            
            dfs(nextSheep,nextWolf,next);
        }
    }//dfs end
}//class end