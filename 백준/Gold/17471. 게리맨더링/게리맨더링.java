import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static int n;
    static int[] person;
    static ArrayList<Integer>[] list;
    static boolean[] check;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        person = new int[n+1];
        list = new ArrayList[n+1];
        check = new boolean[n+1];

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
        }else {
            System.out.println(min);
        }
    }


    static boolean bfs(ArrayList<Integer> arr){
        Queue<Integer> que = new LinkedList<>();
        visited = new boolean[n+1];
        que.offer(arr.get(0));
        visited[arr.get(0)] = true;

        int count =1;
        while(!que.isEmpty()){
            int now = que.poll();
            for(int i = 0; i < list[now].size(); i++){
                int next = list[now].get(i);
                if(arr.contains(next) && !visited[next]){
                    que.offer(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        if(count == arr.size()){
            return true;
        }else{
            return false;
        }
    }

    static void dfs(int count){
        if(count == n){
            ArrayList<Integer> trueList = new ArrayList<>();
            ArrayList<Integer> fasleList = new ArrayList<>();

            for(int i = 1; i <= n; i++){
                if(check[i]){
                    trueList.add(i);
                }else{
                    fasleList.add(i);
                }
            }
            if(trueList.size() == 0 || fasleList.size() == 0){
                return;
            }
            if(bfs(trueList) && bfs(fasleList)){
                diff();
            }
            return;
        }

        check[count] = true;
        dfs(count+1);
        check[count] = false;
        dfs(count+1);
    }

    static void diff(){
        int trueNum = 0;
        int falseNume = 0;
        for(int i = 1; i <= n; i++){
            if(visited[i]){
                trueNum += person[i];
            }else{
                falseNume += person[i];
            }
        }
        int diff1 = Math.abs(trueNum-falseNume);
        min = Math.min(min,diff1);
    }
}
