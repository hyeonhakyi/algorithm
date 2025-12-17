import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int s;
    static boolean[][] visited = new boolean[1501][1501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        s = A + B + C;
        if(s % 3 != 0){
            System.out.println(0);
            return;
        }

        Queue<Node> q = new LinkedList<>();
        bfs(A, B, C, q);

        while(!q.isEmpty()){
            Node node = q.poll();
            int a = node.x;
            int b = node.y;
            int c = s - a - b;

            if(a == b && b == c){
                System.out.println(1);
                return;
            }

            if(a != b){
                int x = a;
                int y = b;
                bfs(x + x, y - x, c, q);
            }

            if(a != c){
                int x = a;
                int y = c;
                bfs(x + x, b, y - x, q);
            }

            if(b != c){
                int x = b;
                int y = c;
                bfs(a,x + x, y - x, q);
            }
        }

        System.out.println(0);
    }//main end

    private static void bfs(int a, int b, int c, Queue<Node> q){
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        int x = arr[0];
        int y = arr[1];

        if(!visited[x][y]){
            visited[x][y] = true;
            q.add(new Node(x, y));
        }
    }//dfs end
}//class end