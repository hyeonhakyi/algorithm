import java.util.*;

class Node{
    String word;
    int count;
    public Node(String word,int count){
        this.word = word;
        this.count = count;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        answer = bfs(begin,target,words);
        
        return answer;
    }//solution end
    
    private static int bfs(String begin,String target,String[] words){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin,0));
        boolean[] visited = new boolean[words.length];
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.word.equals(target)){
                return now.count;
            }
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && check(now.word,words[i])){
                    visited[i] = true;
                    q.offer(new Node(words[i],now.count + 1));
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
        }
        
        return count == 1;
    }//check end
}//class end