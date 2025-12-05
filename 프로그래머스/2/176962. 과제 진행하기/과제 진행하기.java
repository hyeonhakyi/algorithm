import java.util.*;

class Node{
    String name;
    int startTime;
    int playTime;
    
    public Node(String name,String start,String playTime){
        this.name = name;
        this.startTime = convertTime(start);
        this.playTime = Integer.parseInt(playTime);
    }
    
    private static int convertTime(String time){
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        List<Node> list = new ArrayList<>();
        
        for(String[] plan : plans){
            list.add(new Node(plan[0],plan[1],plan[2]));
        }
        
        list.sort(Comparator.comparingInt(o -> o.startTime));
        
        Stack<Node> stack = new Stack<>();
        
        for(int i = 0; i < list.size() - 1; i++){
            Node current = list.get(i);
            Node next = list.get(i+1);
            
            int currentTotalTime = current.startTime + current.playTime;
            if(next.startTime >= currentTotalTime){
                answer.add(current.name);
                int freeTime = next.startTime - currentTotalTime;
                
                while(freeTime > 0 && !stack.isEmpty()){
                    Node paused = stack.pop();
                    
                    if(freeTime >= paused.playTime){
                        freeTime -= paused.playTime;
                        answer.add(paused.name);
                    }else{
                        paused.playTime -= freeTime;
                        stack.push(paused);
                        break;
                    }
                }
            }else{
                current.playTime -= next.startTime - current.startTime;
                stack.push(current);
            }
        }
        
        answer.add(list.get(list.size() - 1).name);
        
        while(!stack.isEmpty()){
            answer.add(stack.pop().name);
        }
        
        return answer.toArray(new String[0]);
    }
}