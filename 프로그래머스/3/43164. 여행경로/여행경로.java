import java.util.*;

class Solution {
    static boolean[] visited;
    static String[] answer;
    static boolean finished;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new String[tickets.length + 1];
        finished = false;
        
        Arrays.sort(tickets, (a,b) -> {
           if(a[0].equals(b[0])){
               return a[1].compareTo(b[1]);
           };
            return a[0].compareTo(b[0]);
        });
        
        dfs("ICN",tickets,0,new ArrayList<>());
        
        return answer;
    }//solution end
    
    private static void dfs(String now,String[][] tickets,int count,List<String> list){
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
                
                dfs(tickets[i][1],tickets,count + 1,list);
                
                visited[i] = false;
            }
        }
        
        list.remove(list.size() - 1);
    }//dfs end
}//class end