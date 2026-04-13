import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int[] team;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new List[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for(int j = 0; j < cnt; j++){
                int hate = Integer.parseInt(st.nextToken());

                list[i].add(hate);
                list[hate].add(i);
            }
        }

        team = new int[n + 1];
        Arrays.fill(team, 0);

        for(int i = 1; i <= n; i++){
            if(team[i] == 0){
                bfs(i);
            }
        }

        List<Integer> blueList = new ArrayList<>();
        List<Integer> whiteList = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(team[i] == 1){
                blueList.add(i);
            }else{
                whiteList.add(i);
            }
        }

        Collections.sort(blueList);
        Collections.sort(whiteList);

        StringBuilder sb = new StringBuilder();
        sb.append(blueList.size()).append("\n");
        for(int i : blueList){
            sb.append(i).append(" ");
        }
        sb.append("\n");

        sb.append(whiteList.size()).append("\n");
        for(int i : whiteList){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }//main end

    private static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        team[start] = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : list[now]){
                if(team[next] == 0){
                    team[next] = -team[now];
                    q.offer(next);
                }
            }
        }
    }//bfs end
}//class end
