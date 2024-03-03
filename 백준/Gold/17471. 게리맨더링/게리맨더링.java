
import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n,min;
    private static int[] person;
    private static boolean[] visited;
    private static boolean[] check;
    private static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        person = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        min = Integer.MAX_VALUE;

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            person[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        dfs(0);
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }//main end

    private static void dfs(int count){
        if(count == n) {
            ArrayList<Integer> trueList = new ArrayList<>();
            ArrayList<Integer> falseList = new ArrayList<>();

            for(int i = 1; i <= n; i++){
                if(visited[i]){
                    trueList.add(i);
                }else{
                    falseList.add(i);
                }
            }

            if(trueList.isEmpty() || falseList.isEmpty())return;

            if(bfs(trueList) && bfs(falseList)){
                diff();
            }
            return;
        }

        visited[count] = true;
        dfs(count+1);
        visited[count] = false;
        dfs(count+1);
    }//dfs end

    private static boolean bfs(ArrayList<Integer> arr){
        Queue<Integer> que = new LinkedList<>();
        check = new boolean[n+1];
        que.offer(arr.get(0));
        check[arr.get(0)] = true;

        int count = 1;
        while(!que.isEmpty()){
            int now = que.poll();
            for(int i = 0; i < list[now].size(); i++){
                int next = list[now].get(i);
                if(arr.contains(next) && !check[next]){
                    check[next] = true;
                    que.offer(next);
                    count++;
                }
            }
        }
        if(count == arr.size()){
            return true;
        }else{
            return false;
        }
    }//bfs end

    private static void diff(){
        int trueSum = 0;
        int falseSum = 0;
        for(int i = 1; i <= n; i++){
            if(check[i]){
                trueSum += person[i];
            }else{
                falseSum += person[i];
            }
        }
        min = Math.min(min,Math.abs(trueSum - falseSum));
    }
}//class end
