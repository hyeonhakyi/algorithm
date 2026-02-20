import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = 1;
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0){
                break;
            }

            parents = new int[n + 1];
            check = new boolean[n + 1];

            for (int i = 1; i <= n; i++) { // [수정] DSU 초기화 필수
                parents[i] = i;
                check[i] = false;
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            int tree = 0;
            for(int i = 1; i <= n; i++){
                if(parents[i] == i && !check[i]){
                    tree++;
                }
            }

            if(tree == 0){
                sb.append("Case ").append(testCase).append(": ").append("No trees.");
            }else if(tree == 1){
                sb.append("Case ").append(testCase).append(": ").append("There is one tree.");
            }else{
                sb.append("Case ").append(testCase).append(": ").append("A forest of ").append(tree).append(" trees.");
            }

            sb.append("\n");
            testCase++;
        }//testCase end

        System.out.println(sb.toString());
    }//main end

    private static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }//find end

    private static void union(int a,int b){
        int fa = find(a);
        int fb = find(b);

        if(fa == fb){
            check[fa] = true;
            return;
        }

        parents[fb] = fa;
        check[fa] = check[fa] || check[fb];
    }//union end
}//class end
