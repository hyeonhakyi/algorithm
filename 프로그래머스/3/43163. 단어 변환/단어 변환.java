import java.util.*;

class Word{
    String word;
    int step;
    
    public Word(String word, int step){
        this.word = word;
        this.step = step;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0;
        
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        q.offer(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word now = q.poll();
            
            if(now.word.equals(target)){
                return now.step;
            }
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && canConvert(now.word,words[i])){
                    visited[i] = true;
                    q.offer(new Word(words[i],now.step+1));
                }
            }
        }
        return 0;
    }
    
    public static boolean canConvert(String a, String b){
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
            }
            
            if(diff > 1) return false;
        }
        
        return diff == 1;
    }
}