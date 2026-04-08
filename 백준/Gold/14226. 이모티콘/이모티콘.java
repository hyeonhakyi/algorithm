import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Node{
        int screen;
        int clip;
        int time;
        public Node(int screen,int clip,int time){
            this.screen = screen;
            this.clip = clip;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        System.out.println(bfs(s));
    }//main end

    private static int bfs(int end){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1,0,0));

        boolean[][] visited = new boolean[2001][2001];
        visited[1][0] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.screen == end){
                return now.time;
            }

            if(!visited[now.screen][now.screen]){
                visited[now.screen][now.screen] = true;
                q.offer(new Node(now.screen,now.screen,now.time + 1));
            }

            if(now.clip > 0 && now.screen + now.clip <= 2000){
                if(!visited[now.screen + now.clip][now.clip]){
                    visited[now.screen + now.clip][now.clip] = true;
                    q.offer(new Node(now.screen + now.clip, now.clip, now.time + 1));
                }
            }

            if(now.screen > 0){
                if(!visited[now.screen - 1][now.clip]){
                    visited[now.screen - 1][now.clip] = true;
                    q.offer(new Node(now.screen - 1,now.clip, now.time + 1));
                }
            }
        }
        return -1;
    }//bfs end
}//class end
