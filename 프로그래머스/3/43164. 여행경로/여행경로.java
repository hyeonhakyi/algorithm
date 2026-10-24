import java.util.*;

class Solution {
    static boolean finished;
    static boolean[] visited;
    static String[] answer;
    public String[] solution(String[][] tickets) {
        finished = false;
        visited = new boolean[tickets.length];
        answer = new String[tickets.length + 1];
        Arrays.sort(tickets,(a,b) -> {
           if(a[0].equals(b[0])){
               return a[1].compareTo(b[1]);
           }
            return a[0].compareTo(b[0]);
        });
        
        dfs("ICN",0,new ArrayList<>(),tickets);
        
        return answer;
    }//solution end
    
    private static void dfs(String now,int count,List<String> list,String[][] tickets){
        if(finished){
            return;
        }
        
        list.add(now);
        
        if(tickets.length == count){
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
            
            finished = true;
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(now)){
                visited[i] = true;
                
                dfs(tickets[i][1],count + 1,list,tickets);
                
                visited[i] = false;
            }
        }
        
        list.remove(list.size() - 1);
    }//dfs end
}//class end