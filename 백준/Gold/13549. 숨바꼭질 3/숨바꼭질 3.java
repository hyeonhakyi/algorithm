
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int start;
        int end;
        public Node(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    static int n,k,ans;
    static boolean[] visited = new boolean[100001];
    static int time = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k){
            System.out.println(0);
        }else{
            bfs(n);
            System.out.println(time);
        }
    }

    static void bfs(int n){
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(n,0));
        visited[n] = true;

        while(!que.isEmpty()){
            Node now = que.poll();

            if(now.start == k){
                time = Math.min(time,now.end);
            }

            int next;
            next = now.start*2;

            if(next < 100001 && !visited[next]){
                visited[next] = true;
                que.offer(new Node(next,now.end));
            }

            next = now.start -1;
            if(next >= 0 && !visited[next]){
                visited[next] = true;
                que.offer(new Node(next, now.end + 1 ));
            }

            next = now.start + 1;
            if(next < 100001 && !visited[next]){
                visited[next] = true;
                que.offer(new Node(next, now.end + 1 ));
            }
        }
    }
}
