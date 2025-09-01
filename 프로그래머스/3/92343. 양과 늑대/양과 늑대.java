import java.util.*;

class Solution {
    static List<Integer>[] list;
    static int[] info;
    static int maxSheep = 0;
    public int solution(int[] info, int[][] edges) {
        Solution.info = info;
        int n = info.length;
        
        list = new ArrayList[n];
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] i : edges){
            list[i[0]].add(i[1]);
        }
        
        List<Integer> candidate = new ArrayList<>();
        candidate.add(0);
        dfs(0,0,candidate);
        
        return maxSheep;
    }
    
    public static void dfs(int wolf,int sheep,List<Integer> can){
        maxSheep = Math.max(sheep,maxSheep);
        
        for(int i = 0; i < can.size(); i++){
            int next = can.get(i);
            
            int newSheep = sheep;
            int newWolf = wolf;
            
            if(info[next] == 0){
                newSheep++;   
            }else{
                newWolf++;
            }
            
            if(newWolf >= newSheep) continue;
            
            List<Integer> newCan = new ArrayList<>(can);
            newCan.remove(i);
            newCan.addAll(list[next]);
            
            dfs(newWolf,newSheep,newCan);
        }
    }//dfs end
}