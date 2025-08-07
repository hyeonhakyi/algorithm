import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int hight;
        int idx;
        public Node(int hight, int idx){
            this.hight = hight;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Node> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()){
                sb.append("0 ");
                stack.push(new Node(num, i));
            }else{
                while(true){
                    if(stack.isEmpty()){
                        sb.append("0 ");
                        stack.push(new Node(num, i));
                        break;
                    }

                    Node top = stack.peek();
                    if(top.hight > num){
                        sb.append(top.idx + " ");
                        stack.push(new Node(num, i));
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(sb);
    }//main end
}//class end
