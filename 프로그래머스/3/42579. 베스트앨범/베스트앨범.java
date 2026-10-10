import java.util.*;

class Music implements Comparable<Music>{
    int count;
    int idx;
    public Music(int count,int idx){
        this.count = count;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Music o){
        if(this.count == o.count){
            return Integer.compare(this.idx,o.idx);
        }
        return Integer.compare(o.count,this.count);
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Music> list = new ArrayList<>();
        
        for(int i = 0; i < plays.length; i++){
            list.add(new Music(plays[i],i)); 
        }
        
        Collections.sort(list);
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < plays.length; i++){
            map.put(genres[i],map.getOrDefault(genres[i],0) + plays[i]);
        }
        
        List<String> genresList = new ArrayList<>(map.keySet());
        
        genresList.sort((a,b) ->
            Integer.compare(map.get(b),map.get(a))
        );
        
        List<Integer> answerList = new ArrayList<>();
        
        for(String genre : genresList){
            int count = 0;
            
            for(Music music : list){
                if(genres[music.idx].equals(genre)){
                    count++;
                    answerList.add(music.idx);
                    
                }
                
                if(count == 2){
                    break;
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }//solution end
}//class end