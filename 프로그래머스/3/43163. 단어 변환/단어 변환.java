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
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        answer = bfs(begin,target,words);
        
        return answer;
    }//solution end
    
    private static int bfs(String start,String target,String[] words){
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(start,0));
        
        while(!q.isEmpty()){
            Word now = q.poll();
            
            if(now.word.equals(target)){
                return now.count;
            }
            
            for(int i = 0; i < words.length; i++){
                if(visited[i]) continue;
                if(!check(words[i],now.word)) continue;
                
                visited[i] = true;
                q.offer(new Word(words[i],now.count + 1));
            }
        }
        return 0;
    }//dfs end
    
    private static boolean check(String a,String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        
        if(count == 1){
            return true;
        }else{
            return false;
        }
    }//check end
}//class end