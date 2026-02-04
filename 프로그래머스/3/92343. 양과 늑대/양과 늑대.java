import java.util.*;

class Solution {
    static List<Integer>[] list;
    static int[] info;
    static int maxSheep = 0;
    public int solution(int[] info, int[][] edges) {
        Solution.info = info;
        
        list = new ArrayList[info.length];
        
        for(int i = 0; i < info.length; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            int s = e[0];
            int en = e[1];
            
            list[s].add(en);
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(0);
        
        dfs(0,0,list);
        
        return maxSheep;
    }//main end
    
    private static void dfs(int sheep,int wolf,List<Integer> can){
        maxSheep = Math.max(maxSheep,sheep);
        
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
            
            dfs(newSheep,newWolf,newCan);
        }
    }//dfs end
}//class end