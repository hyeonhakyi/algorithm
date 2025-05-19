import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] arr;
    static int n;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= n; i++){
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list){
            System.out.println(i);
        }
    }//main end

    private static void dfs(int start, int target) {
        if(!visited[arr[start]]){
            visited[arr[start]] = true;
            dfs(arr[start],target);
            visited[arr[start]] = false;
        }
            
        if(arr[start] == target){
            list.add(target);
        }
    }//dfs end
}//class end
