import java.util.*;

class Solution {
    static List<String> answer;
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        answer = new LinkedList<>();
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        
        List<String> path = new LinkedList<>();
        path.add("ICN");
        
        dfs("ICN",tickets,path,0);
        
        return answer.toArray(new String[0]);
    }
    
    private static void dfs(String currrnt,String[][] tickets,List<String> path,int ueseTickets){
        if(ueseTickets == tickets.length){
            if(answer.isEmpty()){
                answer = new LinkedList<>(path);
                return;
            }
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(currrnt)){
                visited[i] = true;
                path.add(tickets[i][1]);
                
                dfs(tickets[i][1], tickets,path,ueseTickets + 1);
                
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }//dfs end
}