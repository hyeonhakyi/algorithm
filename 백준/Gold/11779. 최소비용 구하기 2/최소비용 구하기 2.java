import javax.imageio.ImageTranscoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    private static class Node implements Comparable<Node>{
        int idx;
        int value;
        public Node(int idx,int value){
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value,o.value);
        }
    }
    private static int n,m,INF = 987654321;
    private static ArrayList<Node>[] list;
    private static int[] distance;
    private static int[] pre;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        distance = new int[n+1];
        pre = new int[n+1];

        Arrays.fill(distance,INF);

        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,value));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(distance[end]);

        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while (pre[end] != 0){
            cnt += 1;
            stack.push(pre[end]);
            end = pre[end];
        }
        System.out.println(cnt+1);
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }//main end

    private static void dijkstra(int start){
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(start,0));
        distance[start] = 0;

        while(!que.isEmpty()){
            Node now = que.poll();

            if(distance[now.idx] < now.value){
                continue;
            }

            for(Node next : list[now.idx]){
                if(distance[next.idx] > distance[now.idx] + next.value){
                    distance[next.idx] = distance[now.idx] + next.value;
                    pre[next.idx] = now.idx;
                    que.offer(new Node(next.idx, distance[next.idx]));
                }
            }
        }
    }//dijkstra end
}//class end
