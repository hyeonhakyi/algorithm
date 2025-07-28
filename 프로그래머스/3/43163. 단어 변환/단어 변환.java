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
        if(!Arrays.asList(words).contains(target)) return 0;
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        q.offer(new Node(begin,0));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.word.equals(target)){
                return now.count;
            }
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && canCov(words[i],now.word)){
                    q.offer(new Node(words[i],now.count+1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    public static boolean canCov(String a,String b){
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
            }
            if(diff > 1){
                return false;
            } 
        }
        return diff == 1;
    }
}