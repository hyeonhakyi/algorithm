import java.util.*;

class Node{
    String genres;
    int play;
    int num;
    public Node(String genres,int play,int num){
        this.genres = genres;
        this.play = play;
        this.num = num;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i],map.getOrDefault(genres[i],0) + plays[i]);
        }
        
        ArrayList<String> order = new ArrayList<>();
        while(!map.isEmpty()){
            int max = -1;
            String maxGeners = "";
            for(String key : map.keySet()){
                int cntMax = map.get(key);
                if(max < cntMax){
                    max = cntMax;
                    maxGeners = key;
                }
            }
            order.add(maxGeners);
            map.remove(maxGeners);
        }
        
        ArrayList<Node> result = new ArrayList<>();
        for(String r : order){
            ArrayList<Node> list = new ArrayList<>();
            for(int i = 0; i < genres.length; i++){
                if(genres[i].equals(r)){
                    list.add(new Node(r,plays[i],i));
                }
            }
            
            Collections.sort(list, (o1,o2) -> o2.play - o1.play);
            result.add(list.get(0));
            if(list.size() != 1){
                result.add(list.get(1));
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            Node now = result.get(i);
            answer[i] = now.num;
        }
        
        return answer;
    }//main end
}//class end