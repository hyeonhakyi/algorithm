import java.util.*;

class Word{
    String word;
    int count;
    public Word(String word,int count){
        this.word = word;
        this.count = count;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if(!Arrays.asList(words).contains(target)) return 0;
        Queue<Word> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        q.offer(new Word(begin,0));
        
        while(!q.isEmpty()){
            Word now = q.poll();
            
            if(now.word.equals(target)){
                return now.count;
            }
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && canCov(words[i],now.word)){
                    q.offer(new Word(words[i],now.count + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }//main end
    
    private static boolean canCov(String word,String target){
        int diff = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) != target.charAt(i)){
                diff++;
            }
            
            if(diff > 1){
                return false;
            }
        }
        return diff == 1;
    }//canCov end
}