import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch(order) {
                case "push_front": {
                    int value = Integer.parseInt(st.nextToken());
                    dq.addFirst(value);
                    break;
                }
                case "push_back": {
                    int value = Integer.parseInt(st.nextToken());
                    dq.addLast(value);
                    break;
                }
                case "pop_front": {
                    if(dq.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(dq.pollFirst()).append("\n");
                    }
                    break;
                }
                case "pop_back": {
                    if(dq.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(dq.pollLast()).append("\n");
                    }
                    break;
                }
                case "size": {
                    sb.append(dq.size()).append("\n");
                    break;
                }
                case "empty": {
                    sb.append(dq.isEmpty() ? "1" : "0").append("\n");
                    break;
                }
                case "front": {
                    if(dq.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(dq.peekFirst()).append("\n");
                    }
                    break;
                }
                case "back": {
                    if(dq.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(dq.peekLast()).append("\n");
                    }
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
