import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] h = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) h[i] = Integer.parseInt(st.nextToken());

        // 보이는 건물 수 합산용
        int[] count = new int[N + 1];
        // 좌/우에서 가장 가까운 보이는 건물 후보
        int[] leftNear = new int[N + 1];
        int[] rightNear = new int[N + 1];

        Stack<Integer> stack = new Stack<>();

        // 1) 왼쪽에서 바라본 보임 처리: 좌 -> 우
        //    현재보다 작거나 같은 건물은 가려지므로 pop, 남은 것들은 모두 보임
        stack.clear();
        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) stack.pop(); // ★ 가리는 건물 제거
            count[i] += stack.size();                                       // ★ 남은 건물 수 = 왼쪽에서 보이는 수
            if (!stack.isEmpty()) leftNear[i] = stack.peek();               // ★ 가장 가까운 왼쪽 보이는 건물
            stack.push(i);
        }

        // 2) 오른쪽에서 바라본 보임 처리: 우 -> 좌
        stack.clear();
        for (int i = N; i >= 1; i--) {
            while (!stack.isEmpty() && h[stack.peek()] <= h[i]) stack.pop(); // ★ 가리는 건물 제거
            count[i] += stack.size();                                        // ★ 남은 건물 수 = 오른쪽에서 보이는 수
            if (!stack.isEmpty()) rightNear[i] = stack.peek();               // ★ 가장 가까운 오른쪽 보이는 건물
            stack.push(i);
        }

        // 3) 출력: 보이는 수와, 있다면 가장 가까운 건물 번호(거리 비교, 같으면 작은 번호)
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                sb.append(0).append('\n');
            } else {
                int ln = leftNear[i];
                int rn = rightNear[i];
                int pick;
                if (ln == 0) {
                    pick = rn;
                } else if (rn == 0) {
                    pick = ln;
                } else {
                    int dL = i - ln;
                    int dR = rn - i;
                    if (dL < dR) pick = ln;
                    else if (dL > dR) pick = rn;
                    else pick = Math.min(ln, rn); // ★ 거리가 같으면 더 작은 번호
                }
                sb.append(count[i]).append(' ').append(pick).append('\n');
            }
        }

        System.out.print(sb);
    }
}
