import java.util.*;

class Solution {
    static List<String> answer = new ArrayList<>();
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN",path,tickets,0);
        
        return answer.toArray(new String[0]);
    }//main end
    
    private static void dfs(String start,List<String> path,String[][] tickets,int use){
        if(use == tickets.length){
            if(answer.isEmpty()){
                answer = new LinkedList<>(path);
            }
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                path.add(tickets[i][1]);
                
                dfs(tickets[i][1],path,tickets,use+1);
                
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }//dfs end
}//class end