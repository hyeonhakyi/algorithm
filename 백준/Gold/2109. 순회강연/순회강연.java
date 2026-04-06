import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int day;
        int value;
        public Node(int day,int value){
            this.day = day;
            this.value = value;
        }
        @Override
        public int compareTo(Node o){
            if(this.day == o.day){
                return Integer.compare(this.value,o.value);
            }
            return Integer.compare(this.day, o.day);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] arr = new Node[n];


        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            arr[i] = new Node(day,value);
        }

        Arrays.sort(arr);
        
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(Node now : arr){
            q.offer(now.value);
            
            if(q.size() > now.day){
                q.poll();
            }
        }
        
        int answer = 0;
        
        while(!q.isEmpty()){
            answer += q.poll();
        }
        
        System.out.println(answer);
    }//main end
}//class end
