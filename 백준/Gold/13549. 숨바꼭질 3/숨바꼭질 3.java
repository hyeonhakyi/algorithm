import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int x;
        int count;
        public Node(int x, int count){
            this.x = x;
            this.count = count;
        }
    }
    static boolean[] check = new boolean[100001];
    static int n,k,result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;

        if(n == k){
            System.out.println(0);
        }else{
            bfs();
            System.out.println(result);
        }
    }//main end

    private static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));
        check[n] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int now = cur.x;
            int nCount = cur.count;

            if(now == k){
                result = Math.min(result, nCount);
            }

            int next;
            next = now * 2;
            if(next < 100001 && !check[next]){
                q.offer(new Node(next, nCount));
                check[next] = true;
            }

            next = now - 1;
            if(next >= 0 && !check[next]){
                q.offer(new Node(next, nCount + 1));
                check[next] = true;
            }

            next = now + 1;
            if(next < 100001 && !check[next]){
                q.offer(new Node(next, nCount + 1));
                check[next] = true;
            }
        }
    }//bfs end
}//class end
