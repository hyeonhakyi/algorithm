import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int weight;
        int value;
        public Node(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
        @Override
        public int compareTo(Node o) {
            if(this.weight != o.weight){
                return this.weight - o.weight;
            }else{
                return o.value - this.value;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Node[] jewels = new Node[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Node(weight, value);
        }

        int[] bags = new int[k];
        for(int i = 0; i < k; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;
        int j = 0;

        for(int i : bags){
            while(j < n && jewels[j].weight <= i){
                pq.offer(jewels[j].value);
                j++;
            }

            if(!pq.isEmpty()){
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }//main end
}//class end
