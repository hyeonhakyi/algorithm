import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n,deleteNode,root;
    static List<Integer>[] list;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n];
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        root = -1;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());

            if(num == -1){
                root = i;
            }else{
                list[num].add(i);
            }
        }

        deleteNode = Integer.parseInt(br.readLine());

        if(deleteNode == root){
            System.out.println(0);
            return;
        }

        dfs(root);

        System.out.println(answer);
    }//main end

    private static void dfs(int u) {
        int remainChild = 0;

        for(int num : list[u]){
            if(num == deleteNode) continue;
            remainChild++;
            dfs(num);
        }

        if(remainChild == 0) answer++;
    }//dfs end
}//class end
