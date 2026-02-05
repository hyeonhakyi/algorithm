import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        Map<String, Node> child = new TreeMap<>();
    }

    static Node root = new Node();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            Node cur = root;
            for(int j = 0; j < m; j++){
                String str = st.nextToken();
                cur.child.putIfAbsent(str, new Node());
                cur = cur.child.get(str);
            }
        }

        dfs(root, 0);

        System.out.println(sb.toString());
    }//main end

    private static void dfs(Node node,int depth){
        for(String key : node.child.keySet()){
            sb.append("--".repeat(depth)).append(key).append("\n");
            dfs(node.child.get(key),depth + 1);
        }
    }//dfs end
}//class end
