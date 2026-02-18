import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int s;
        int e;
        public Node(int s,int e){
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] arr = new Node[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            arr[i] = new Node(s, t);
        }

        Arrays.sort(arr,(a,b) -> {
            if(a.s != b.s) {
                return Integer.compare(a.s,b.s);
            } else {
                return Integer.compare(a.e,b.e);
            }
        });

        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(Node l : arr){
            if(!q.isEmpty() && q.peek() <= l.s){
                q.poll();
            }
            q.offer(l.e);
        }

        System.out.println(q.size());
    }//main end
}//class end
