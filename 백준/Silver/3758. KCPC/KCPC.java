import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int id;
        int score;
        int count;
        int time;
        public Node(int id,int score,int count,int time){
            this.id = id;
            this.score = score;
            this.count = count;
            this.time = time;
        }

        @Override
        public int compareTo(Node o){
            if(o.score == this.score){
                if(o.count == this.count){
                    return this.time - o.time;
                }
                return this.count - o.count;
            }
            return o.score - this.score;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] best = new int[n+1][k+1];
            int[] sum = new int[n+1];
            int[] cnt = new int[n+1];
            int[] last = new int[n + 1];

            for(int i = 1; i <= m; i++){
                st = new StringTokenizer(br.readLine());
                int team = Integer.parseInt(st.nextToken());
                int prob = Integer.parseInt(st.nextToken());
                int sc = Integer.parseInt(st.nextToken());

                cnt[team]++;
                last[team] = i;

                if(sc > best[team][prob]){
                    sum[team] += (sc - best[team][prob]);
                    best[team][prob] = sc;
                }
            }

            List<Node> list = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                list.add(new Node(i,sum[i],cnt[i],last[i]));
            }

            Collections.sort(list);

            int rank = 1;
            for(Node team : list){
                if(team.id == t){
                    break;
                }
                rank++;
            }
            sb.append(rank).append("\n");
        }
        System.out.println(sb.toString());
    }//main end
}//class end
