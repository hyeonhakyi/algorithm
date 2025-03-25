import java.util.*;

class Solution {
    
    static class Task{
        String name;
        int startTime;
        int playTime;
        
        public Task(String name, String start, String playtime){
            this.name = name;
            this.startTime = convertTime(start);
            this.playTime = Integer.parseInt(playtime);
        }
        
        private int convertTime(String time){
            String[] parts = time.split(":");
            return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]); 
        }
    }
    public String[] solution(String[][] plans) {
        List<String> result = new ArrayList<>();
        
        List<Task> tasks = new ArrayList<>();
        for(String[] plan : plans){
            tasks.add(new Task(plan[0],plan[1],plan[2]));
        }
        
        tasks.sort(Comparator.comparingInt(o -> o.startTime));
        
        Stack<Task> pausedTasks = new Stack<>();
        
        for(int i = 0; i < tasks.size() - 1; i++){
            Task current = tasks.get(i);
            Task next = tasks.get(i + 1);
            
            int currentEndTime = current.startTime + current.playTime;
            
            if(currentEndTime <= next.startTime){
                result.add(current.name);
                int freeTime = next.startTime - currentEndTime;
                
                while(freeTime > 0 &&  !pausedTasks.isEmpty()){
                    Task paused = pausedTasks.pop();
                    
                    if(freeTime >= paused.playTime){
                        freeTime -= paused.playTime;
                        result.add(paused.name);
                    }else{
                        paused.playTime -= freeTime;
                        pausedTasks.push(paused);
                        break;
                    }
                }
            }else{
                current.playTime -= next.startTime - current.startTime;
                pausedTasks.push(current);
            }
        }
        
        result.add(tasks.get(tasks.size() - 1).name);
        
        while(!pausedTasks.isEmpty()){
            result.add(pausedTasks.pop().name);
        }
        
        return result.toArray(new String[0]);
    }
}