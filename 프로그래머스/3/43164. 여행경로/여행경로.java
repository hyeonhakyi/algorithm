import java.util.*;

class Solution {
    static List<String> answer;
    static boolean found;
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets,(a,b) -> {
            if(a[0].equals(b[0])){
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        boolean[] visited = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN","ICN",tickets,visited,path,0);
        
        return answer.toArray(new String[0]);
    }//solution end
    
    private static void dfs(String now,String start,String[][] tickets,boolean[] visited,List<String> path,int count){
        if(found) return;
        
        if(count == tickets.length){
            answer = new ArrayList<>(path);
            found = true;
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(now)){
                visited[i] = true;
                path.add(tickets[i][1]);
                
                dfs(tickets[i][1],start,tickets,visited,path,count + 1);
                
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }//dfs end 
}//class end