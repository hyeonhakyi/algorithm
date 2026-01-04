import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> preorder = new ArrayList<Integer>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while((line = br.readLine()) != null && !line.isEmpty()) {
            preorder.add(Integer.parseInt(line));
        }

        postOrder(0,preorder.size() - 1);

        System.out.println(sb.toString());
    }//main end

    static void postOrder(int start, int end) {
        if(start > end) return;

        int root = preorder.get(start);

        int mid = start + 1;
        while(mid <= end && preorder.get(mid) < root) {
            mid++;
        }

        postOrder(start + 1, mid - 1);
        postOrder(mid, end);
        sb.append(root).append("\n");
    }//postOrder end
}//class end
