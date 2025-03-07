
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int T,n,k,t,m;
    static int[][] logs;
    static List<Info> list;
    static StringBuilder sb = new StringBuilder();

    static class Info implements Comparable<Info>{
        int id;
        int score;
        int cnt;
        int time;
        public Info(int id, int score, int cnt, int time){
            this.id = id;
            this.score = score;
            this.cnt = cnt;
            this.time = time;
        }

        @Override
        public int compareTo(Info o) {
            if(this.score == o.score){
                if(this.cnt == o.cnt){
                    return this.time - o.time;
                }
                return this.cnt - o.cnt;
            }
            return o.score - this.score;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            logs = new int[m][3];

            for(int x = 0; x < m; x++){
                st = new StringTokenizer(br.readLine()," ");
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                logs[x][0] = i;
                logs[x][1] = j;
                logs[x][2] = s;
            }

            int[][] saveScore = new int[n + 1][k + 1];
            int[] cntSubmit = new int[n + 1];
            int[] time = new int[n + 1];

            for(int i = 0; i < m; i++){
                int nowId = logs[i][0];
                int nowNum = logs[i][1];
                int nowScore = logs[i][2];

                cntSubmit[nowId]++;
                time[nowId] = i;

                if(nowScore > saveScore[nowId][nowNum]){
                    saveScore[nowId][nowNum] = nowScore;
                }
            }

            list = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                int sum = 0;
                for(int j = 1; j <= k; j++){
                    sum += saveScore[i][j];
                }

                list.add(new Info(i, sum, cntSubmit[i], time[i]));
            }

            Collections.sort(list);

            for(int i = 0; i < n; i++){
                if(list.get(i).id == t){
                    sb.append((i+1) + "\n");
                }
            }
        }//test end
        System.out.println(sb.toString());
    }//main end
}//class end
