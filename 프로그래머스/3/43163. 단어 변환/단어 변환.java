import java.util.*;

class Node{
    String word;
    int cnt;
    public Node(String word,int cnt){
        this.word = word;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        answer = bfs(begin,target,words);
        
        return answer;
    }//solution end
    
    private static int bfs(String start,String target,String[] words){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start,0));
        boolean[] visited = new boolean[words.length];
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.word.equals(target)){
                return now.cnt;
            }
            
            for(int i = 0; i < words.length; i++){
                if(visited[i]) continue;
                if(check(now.word,words[i])){
                    q.offer(new Node(words[i],now.cnt + 1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }//bfs end
    
    private static boolean check(String a,String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
            
            if(count > 1){
                return false;
            }
        }
        return true;
    }//check end
}//class end