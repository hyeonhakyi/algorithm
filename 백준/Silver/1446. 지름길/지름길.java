import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int end;
        int weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
    static int n,d;
    static ArrayList<Node>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList[10002];
        dist = new int[10002];
        
        for(int i = 0; i < 10002; i++){
            dist[i] = i;
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        dijkstra(0);
        System.out.println(dist[d]);
    }//main end

    static void dijkstra(int start){
        if(start > d){
            return;
        }

        if(dist[start + 1] > dist[start] + 1){
            dist[start + 1] = dist[start] + 1;
        }

        for(int i = 0; i < list[start].size(); i++){
            if(dist[start] + list[start].get(i).weight < dist[list[start].get(i).end]){
                dist[list[start].get(i).end] = dist[start] + list[start].get(i).weight;
            }
        }
        dijkstra(start + 1);
    }//dijkstra end
}//class end
