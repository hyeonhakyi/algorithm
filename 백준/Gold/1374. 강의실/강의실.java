import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int start;
        int end;
        public Node(int start,int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Node o){
            if(this.start == o.start){
                return Integer.compare(this.end, o.end);
            }
            return Integer.compare(this.start, o.start);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] arr = new Node[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Node(start, end);
        }

        Arrays.sort(arr);
        
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(Node num : arr){
            if(!q.isEmpty() && q.peek() <= num.start){
                q.poll();
            }

            q.offer(num.end);
        }

        System.out.println(q.size());
    }//main end
}//class end
