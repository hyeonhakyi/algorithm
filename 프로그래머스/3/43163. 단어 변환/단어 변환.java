
import java.util.*;

class Word{
    String word;
    int dist;
    public Word(String word,int dist){
        this.word = word;
        this.dist = dist;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean check = false;
        for(String w : words){
            if(w.equals(target)){
                check = true;
                break;
            }
        }
        
        if(!check){
            return 0;
        }
        
        boolean[] visited = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin,0));
        
        while(!q.isEmpty()){
            Word now = q.poll();
            
            if(now.word.equals(target)){
                return now.dist;
            }
            
            for(int i = 0; i < words.length; i++){
                if(visited[i]) continue;
                if(diffCheck(now.word,words[i])){
                    q.offer(new Word(words[i],now.dist + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }//solution end
    
    private static boolean diffCheck(String a,String b){
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
    }//diffCheck end
}//class end