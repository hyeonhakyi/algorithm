import java.util.*;

class Solution {
    static int n,answer;
    static List<Integer>[] list;
    static int[] infoArr;
    public int solution(int[] info, int[][] edges) {
        answer = 0;
        n = info.length;
        list = new ArrayList[n];
        infoArr = info;
        
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            list[edge[0]].add(edge[1]);
        }
        
        List<Integer> nextNode = new ArrayList<>();
        nextNode.add(0);
        dfs(0,0,nextNode);
        
        return answer;
    }//solution end
    
    private static void dfs(int sheep,int wolf,List<Integer> nowNode){
        answer = Math.max(answer,sheep);
        
        for(int i = 0; i < nowNode.size(); i++){
            int current = nowNode.get(i);
            
            int nextSheep = sheep;
            int nextWolf = wolf;
            
            if(infoArr[current] == 0){
                nextSheep++;    
            }else{
                nextWolf++;
            }
            
            if(nextWolf >= nextSheep){
                continue;
            }
            
            List<Integer> nextNode = new ArrayList<>(nowNode);
            for(int next : list[current]){
                nextNode.add(next);
            }
            
            nextNode.remove(i);
            dfs(nextSheep,nextWolf,nextNode);
        }
    }//dfs end
}//class end