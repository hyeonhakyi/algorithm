import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int num;
        int gold;
        int silver;
        int bronze;
        int rate;
        public Node(int num, int gold, int silver, int bronze,int rate) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rate = rate;
        }
        public int compareTo(Node o) {
            if(this.gold == o.gold){
                if(this.silver == o.silver){
                    return o.bronze - this.bronze;
                }else{
                    return o.silver - this.silver;
                }
            }else{
                return o.gold - this.gold;
            }
        }
    }
    static int n,k;
    static ArrayList<Node> nodes;
    static int end_point = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nodes = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            nodes.add(new Node(num,gold,silver,bronze,0));
        }
        Collections.sort(nodes);
        nodes.get(0).rate = 1;

        for(int i = 1; i < nodes.size(); i++){
            int tmp_gold = nodes.get(i-1).gold;
            int tmp_silver = nodes.get(i-1).silver;
            int tmp_bronze = nodes.get(i-1).bronze;
            Node now = nodes.get(i);

            if(nodes.get(i).num == k){
                end_point = i;
            }

            if(now.gold == tmp_gold && now.silver == tmp_silver && now.bronze == tmp_bronze){
                nodes.get(i).rate = nodes.get(i-1).rate;
            }else{
                nodes.get(i).rate = i + 1;
            }
        }

        System.out.println(nodes.get(end_point).rate);
    }//class end
}//main end
