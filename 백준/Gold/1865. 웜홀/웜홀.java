import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class Node{
        int position;
        int time;
        int value;
        public Node(int position, int time,int value){
            this.position = position;
            this.time = time;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            ArrayList<Node> nodes = new ArrayList<>();

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                nodes.add(new Node(s, e, cost));
                nodes.add(new Node(e, s, cost));
            }

            for(int i = 0; i < w; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                nodes.add(new Node(s, e, -cost));
            }
            
            int MAX = 500_001;
            int[] dis = new int[n+1];
            Arrays.fill(dis,MAX);
            dis[1] = 0;

            for(int i = 0; i < n-1; i++){
                for(Node node : nodes){
                    if(dis[node.time] > dis[node.position] + node.value){
                        dis[node.time] = dis[node.position] + node.value;
                    }
                }
            }

            boolean check = false;
            for(Node node : nodes){
                if(dis[node.time] > dis[node.position] + node.value){
                    check = true;
                    break;
                }
            }
            if(check){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }//testCase end
    }//main end
}//class end
