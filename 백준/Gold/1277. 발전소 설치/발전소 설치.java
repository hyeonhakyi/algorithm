import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int idx;
        double w;
        public Node(int idx,double w){
            this.idx = idx;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        double m = Double.parseDouble(br.readLine());
        double m2 = m * m;

        int[] x = new int[n + 1];
        int[] y = new int[n + 1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        List<Node>[] list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < w; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, 0));
            list[b].add(new Node(a, 0));
        }


        for(int i = 1; i <= n; i++){
            for(int j = i + 1; j <= n; j++){
                long dx = (long)x[i] - x[j];
                long dy = (long)y[i] - y[j];
                double d2 = (double) dx*dx + (double) dy*dy;

                if(d2 <= m2){
                    double d = Math.sqrt(d2);
                    list[i].add(new Node(j,d));
                    list[j].add(new Node(i,d));
                }
            }
        }

        double[] dist = new double[n + 1];
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<double[]> q = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));
        q.offer(new double[]{0, 1});
        
        while(!q.isEmpty()){
            double[] cur = q.poll();
            double d = cur[0];
            int v = (int) cur[1];
            
            if(d != dist[v]) continue;
            if(v == n) break;
            
            for(Node next : list[v]){
                double nextD = d + next.w;
                if(nextD < dist[next.idx]){
                    dist[next.idx] = nextD;
                    q.offer(new double[]{nextD, next.idx});
                }
            }
        }

        System.out.println((long)(dist[n] * 1000.0));
    }//main end
}//class end
