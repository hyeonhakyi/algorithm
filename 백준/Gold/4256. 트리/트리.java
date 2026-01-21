import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int[] preorder;
    static int[] inorder;
    static HashMap<Integer, Integer> indexMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            int n = Integer.parseInt(br.readLine());

            preorder = new int[n];
            inorder = new int[n];
            indexMap = new HashMap<>();
            sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                preorder[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                inorder[i] = Integer.parseInt(st.nextToken());
                indexMap.put(inorder[i],i);
            }

            dfs(0,n-1,0,n-1);
            System.out.println(sb.toString());
        }//testCase end
    }//main end

    private static void dfs(int ps, int pe, int is, int ie){
        if(ps > pe || is > ie) return;

        int root = preorder[ps];
        int rootIndex = indexMap.get(root);
        int leftSize = rootIndex - is;

        //왼쪽 서브트리
        dfs(ps + 1,ps + leftSize + 1,is,rootIndex - 1);

        //오른쪽 서브트리
        dfs(ps + leftSize + 1,pe,rootIndex + 1,ie);

        sb.append(root).append(" ");
    }//dfs end
}//class end
