import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    private static class Node {
        int protein;
        int fat;
        int crab;
        int vitamin;
        int price;

        public Node(int protein, int fat, int crab, int vitamin, int price) {
            this.protein = protein;
            this.fat = fat;
            this.crab = crab;
            this.vitamin = vitamin;
            this.price = price;
        }
    }

    private static int n;
    private static int[] target;
    private static boolean[] visited;
    private static Node[] node;
    private static ArrayList<Integer> list = new ArrayList<>();
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        node = new Node[n];
        visited = new boolean[n];
        target = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int protein = Integer.parseInt(st.nextToken());
            int fat = Integer.parseInt(st.nextToken());
            int crab = Integer.parseInt(st.nextToken());
            int vitamin = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            node[i] = new Node(protein, fat, crab, vitamin, price);
        }

        dfs(0, 0, 0, 0, 0, 0);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
            for(int i = 0; i < list.size(); i++){
                System.out.print(list.get(i) + " ");
            }
        }
    }//main end

    private static void dfs(int index, int p, int f, int c, int v, int amount) {
        if (p >= target[0] && f >= target[1] && c >= target[2] && v >= target[3]) {
            if (amount < min) {
                min = amount;
                list.clear();
                for (int i = 0; i < n; i++) {
                    if (visited[i]) {
                        list.add(i + 1);
                    }
                }
            }
        }

        if (index >= n || amount >= min) return;

        visited[index] = true;
        dfs(index + 1, p + node[index].protein, f + node[index].fat,
                c + node[index].crab, v + node[index].vitamin, amount + node[index].price);
        visited[index] = false;
        dfs(index + 1, p, f, c, v, amount);
    }//dfs end
}//class end
