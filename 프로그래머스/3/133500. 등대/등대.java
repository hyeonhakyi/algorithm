import java.util.*;

class Solution {
    static int N,result = 0;
    static List<List<Integer>> map = new ArrayList<>();
    public int solution(int n, int[][] lighthouse) {
        N = n;
        for(int i = 0; i <= N; i++){
            map.add(new ArrayList<>());
        }
        for(int i = 0; i < lighthouse.length; i++){
            map.get(lighthouse[i][0]).add(lighthouse[i][1]);
            map.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }
        
        dfs(1,0);
        return result;
    }
    static int dfs(int now,int before){
        if(map.get(now).size() == 1 && map.get(now).get(0) == before){
            return 1;
        }
        
        int tmp = 0;
        for(int i = 0; i < map.get(now).size(); i++){
            int next = map.get(now).get(i);
            if(next == before) continue;
            tmp += dfs(next,now);
        }
        if(tmp == 0){
            return 1;
        }
        result++;
        return 0;
    }
}