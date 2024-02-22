import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main{

    static class Node implements Comparable<Node>{
        int from;
        int to;
        int num;

        public Node(int from,int to, int num){
            this.from = from;
            this.to = to;
            this.num = num;
        }
        @Override
        public int compareTo(Node o1) {
            return Integer.compare(this.num,o1.num);
        }
    }
    static int v,e;
    static int[] arr;
    static Node[] Node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        arr = new int[v+1];
        Node = new Node[e];

        for(int i = 1; i <= v; i++){
            arr[i] = i;
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            Node[i] = new Node(from,to,num);
        }
        Arrays.sort(Node);

        int cnt = 0;
        long total = 0;
        for(Node i : Node){
            if(!union(i.from,i.to)) continue;
            total += i.num;
            if(++cnt == v-1) break;
        }
        System.out.println(total);
    }

    static int find(int x){
        if(x == arr[x]){
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    static boolean union(int x,int y){
        int x_arr = find(x);
        int y_arr = find(y);

        if(x_arr == y_arr)return false;
        arr[x_arr] = y_arr;
        return true;
    }
}
