import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class Node{
        int x;
        int weight;
        public Node(int x,int weight){
            this.x = x;
            this.weight = weight;
        }
    }
    private static int n;
    private static boolean[] visited;
    private static int max = 0;
    private static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i < list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fir = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int tir = Integer.parseInt(st.nextToken());

            list[fir].add(new Node(two,tir));
            list[two].add(new Node(fir,tir));
        }

        for(int i = 1; i < list.length; i++){
            Arrays.fill(visited,false);
            dfs(i,0);
        }

        System.out.println(max);
    }//main end
    private static void dfs(int node,int sum){
        visited[node] = true;
        max = Math.max(sum,max);

        for(Node value : list[node]){
            int next = value.x;
            int weight = value.weight;
            if(!visited[next]){
                dfs(next,sum+weight);
            }
        }
    }
}//class end
