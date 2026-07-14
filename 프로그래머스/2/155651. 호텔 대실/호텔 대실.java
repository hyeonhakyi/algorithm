import java.util.*;

class Node{
    int start;
    int end;
    public Node(int start,int end){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int solution(String[][] book_time) {
        ArrayList<Node> list = new ArrayList<>();
        
        for(String[] arr : book_time){
            int start = change(arr[0]);
            int end = change(arr[1]) + 10;
            
            list.add(new Node(start,end));
        }
        
        list.sort((a,b) -> {
            if(a.start == b.start){
                return Integer.compare(a.end,b.end);
            }
            return Integer.compare(a.start,b.start);
        });
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(Node next : list){
            if(!q.isEmpty() && q.peek() <= next.start){
                q.poll();
            }
            
            q.offer(next.end);
        }
        
        return q.size();
    }//solution end
    
    private static int change(String time){
        String[] arr = time.split(":");
        
        int hour = Integer.parseInt(arr[0]) * 60;
        int minute = Integer.parseInt(arr[1]);
        
        return hour + minute;
    }//change
}//class end