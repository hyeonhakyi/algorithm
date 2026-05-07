import java.util.*;

class Node implements Comparable<Node>{
    int play;
    int idx;
    public Node(int play,int idx){
        this.play = play;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Node o){
        if(o.play == this.play){
            return Integer.compare(this.idx,o.idx);
        }
        return Integer.compare(o.play,this.play);
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {        
        HashMap<String,Integer> totalMap = new HashMap<>();
        HashMap<String,List<Node>> songMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            totalMap.put(genre,totalMap.getOrDefault(genre,0) + play);
            
            songMap.putIfAbsent(genre,new ArrayList<>());
            songMap.get(genre).add(new Node(play,i));
        }
        
        List<String> genreList = new ArrayList<>(totalMap.keySet());
        
        genreList.sort((a,b) -> totalMap.get(b) - totalMap.get(a));
        
        List<Integer> answerList = new ArrayList<>();
        
        for(String genre : genreList){
            List<Node> songs = songMap.get(genre);
            Collections.sort(songs);
            
            int count = 0;
            
            for(Node song : songs){
                answerList.add(song.idx);
                count++;
                
                if(count == 2){
                    count = 0;
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