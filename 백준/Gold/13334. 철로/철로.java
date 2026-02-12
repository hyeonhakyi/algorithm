import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
            if(o.end == this.end){
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());

            int a = Math.min(h, o);
            int b = Math.max(h, o);
            list.add(new Node(a, b));
        }

        int d = Integer.parseInt(br.readLine());

        List<Node> filterList = new ArrayList<>();
        for(Node node : list){
            if(node.end - node.start > d) continue;
            filterList.add(node);
        }

        Collections.sort(filterList);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int answer = 0;
        for(Node node : filterList){
            int end = node.end;
            int start = node.start;

            pq.add(start);

            int leftBound = end - d;

            while(!pq.isEmpty() && pq.peek() < leftBound){
                pq.poll();
            }

            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }//main end
}//class end
