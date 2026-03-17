import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        cost = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            parents[i] = i;
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(s, v);
        }

        boolean[] checked = new boolean[n + 1];
        int answer = 0;

        for(int i = 1; i <= n; i++){
            int root = find(i);
            if(!checked[root]){
                checked[root] = true;
                answer += cost[root];
            }
        }

        if(answer <= k){
            System.out.println(answer);
        }else{
            System.out.println("Oh no");
        }

    }//main end

    private static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }//find end

    private static void union(int a,int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return;

        if(cost[pa] < cost[pb]){
            parents[pb] = pa;
        }else{
            parents[pa] = pb;
        }
    }
}//class end
