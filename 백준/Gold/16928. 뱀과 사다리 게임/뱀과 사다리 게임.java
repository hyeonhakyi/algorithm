import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int idx;
        int count;
        public Node(int idx, int count){
            this.idx = idx;
            this.count = count;
        }
    }
    static int n,m;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new List[101];

        for(int i = 1; i <= 100; i++){
            list[i] = new LinkedList<>();
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
        }

        int answer = bfs();

        System.out.println(answer);
    }//main end

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1,0));
        boolean[] visited = new boolean[101];
        visited[1] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.idx == 100){
                return now.count;
            }

            for(int i = 1; i <= 6; i++){
                int next = now.idx + i;
                if(next > 100) continue;

                int dest = list[next].isEmpty() ? next : list[next].get(0);

                if(!visited[dest]){
                    visited[dest] = true;
                    q.offer(new Node(dest,now.count + 1));
                }
            }
        }
        return -1;
    }
}//class end
